# CoGroupByKey problem

#### Data description.
I have two datasets.
 - **Records** - the first, containes around 0.5-1M of records per `(key,day)`. For testing I use 2-3 keys and 5-10 days of data. What I shoot for is 1000+ keys. Each record contains key, timestamp in μ-seconds and some other data.
 - **Configs** - the second, is rather small. It describes the key in time, e.g. you can think about it as a list of tuples: `(key, start date, end date, description)`.

For the exploration I've encoded the data as files of length-prefixed Protocol Buffer binary encoded messages. Additionally the files are packed with gzip. Data is sharded by date. Each file is around 10MB.

#### Pipeline
 1. First I add keys to both datasets. For Records dataset it's `(key, day rounded timestamp)`. For Configs a key is `(key, day)`, where day is each timestamp value between `start date` and `end date` (pointing midnight).
 2. The datasets are merged using CoGroupByKey.

As a key type I use `import org.apache.flink.api.java.tuple.Tuple2` with a `Tuple2Coder` from this repo.

### The problem
If the Records dataset is tiny like 5 days, everything seems fine (check [normal_run.log](./normal_run.log)).

```
 INFO [main] (FlinkPipelineRunner.java:124) - Final aggregator values:
 INFO [main] (FlinkPipelineRunner.java:127) - item count : 4322332
 INFO [main] (FlinkPipelineRunner.java:127) - missing val1 : 0
 INFO [main] (FlinkPipelineRunner.java:127) - multiple val1 : 0
```

When I run the pipeline against 10+ days I encounter an error pointing that for some Records there's no Config ([wrong_run.log](./wrong_run.log)).
```
 INFO [main] (FlinkPipelineRunner.java:124) - Final aggregator values:
 INFO [main] (FlinkPipelineRunner.java:127) - item count : 8577197
 INFO [main] (FlinkPipelineRunner.java:127) - missing val1 : 6
 INFO [main] (FlinkPipelineRunner.java:127) - multiple val1 : 0
```

Then I've added some extra logging messages:
```
(ConvertToItem.java:144) - 68643 items for KeyValue3 on: 1462665600000000
(ConvertToItem.java:140) - no items for KeyValue3 on: 1463184000000000
(ConvertToItem.java:123) - missing for KeyValue3 on: 1462924800000000
(ConvertToItem.java:142) - 753707 items for KeyValue3 on: 1462924800000000 marked as no-loc
(ConvertToItem.java:123) - missing for KeyValue3 on: 1462752000000000
(ConvertToItem.java:142) - 749901 items for KeyValue3 on: 1462752000000000 marked as no-loc
(ConvertToItem.java:144) - 754578 items for KeyValue3 on: 1462406400000000
(ConvertToItem.java:144) - 751574 items for KeyValue3 on: 1463011200000000
(ConvertToItem.java:123) - missing for KeyValue3 on: 1462665600000000
(ConvertToItem.java:142) - 754758 items for KeyValue3 on: 1462665600000000 marked as no-loc
(ConvertToItem.java:123) - missing for KeyValue3 on: 1463184000000000
(ConvertToItem.java:142) - 694372 items for KeyValue3 on: 1463184000000000 marked as no-loc
```
You can spot that in first line 68643 items were processed for KeyValue3 and time 1462665600000000.   
Later on in line 9 it seems the operation processes the same key again, but it reports that no Config was available for these Records.  
The line 10 informs they've been marked as no-loc.

The line 2 is saying that there were no items for KeyValue3 and time 1463184000000000, but in line 11 you can read that the items for this (key,day) pair were processed later and they've lacked a Config.

### Some clues
During one of the exploration runs I've got an exception ([exception_thrown.log](./exception_thrown.log)).
```
05/26/2016 03:49:49 GroupReduce (GroupReduce at GroupByKey)(1/5) switched to FAILED
java.lang.Exception: The data preparation for task 'GroupReduce (GroupReduce at GroupByKey)' , caused an error: Error obtaining the sorted input: Thread 'SortMerger spilling thread' terminated due to an exception: Error obtaining the sorted input: Thread 'SortMerger Reading Thread' terminated due to an exception: tried to access field com.esotericsoftware.kryo.io.Input.inputStream from class org.apache.flink.api.java.typeutils.runtime.NoFetchingInput
  at org.apache.flink.runtime.operators.BatchTask.run(BatchTask.java:455)
  at org.apache.flink.runtime.operators.BatchTask.invoke(BatchTask.java:345)
  at org.apache.flink.runtime.taskmanager.Task.run(Task.java:559)
  at java.lang.Thread.run(Thread.java:745)
Caused by: java.lang.RuntimeException: Error obtaining the sorted input: Thread 'SortMerger spilling thread' terminated due to an exception: Error obtaining the sorted input: Thread 'SortMerger Reading Thread' terminated due to an exception: tried to access field com.esotericsoftware.kryo.io.Input.inputStream from class org.apache.flink.api.java.typeutils.runtime.NoFetchingInput
  at org.apache.flink.runtime.operators.sort.UnilateralSortMerger.getIterator(UnilateralSortMerger.java:619)
  at org.apache.flink.runtime.operators.BatchTask.getInput(BatchTask.java:1079)
  at org.apache.flink.runtime.operators.GroupReduceDriver.prepare(GroupReduceDriver.java:94)
  at org.apache.flink.runtime.operators.BatchTask.run(BatchTask.java:450)
  ... 3 more
Caused by: java.io.IOException: Thread 'SortMerger spilling thread' terminated due to an exception: Error obtaining the sorted input: Thread 'SortMerger Reading Thread' terminated due to an exception: tried to access field com.esotericsoftware.kryo.io.Input.inputStream from class org.apache.flink.api.java.typeutils.runtime.NoFetchingInput
  at org.apache.flink.runtime.operators.sort.UnilateralSortMerger$ThreadBase.run(UnilateralSortMerger.java:799)
Caused by: java.lang.RuntimeException: Error obtaining the sorted input: Thread 'SortMerger Reading Thread' terminated due to an exception: tried to access field com.esotericsoftware.kryo.io.Input.inputStream from class org.apache.flink.api.java.typeutils.runtime.NoFetchingInput
  at org.apache.flink.runtime.operators.sort.UnilateralSortMerger.getIterator(UnilateralSortMerger.java:619)
  at org.apache.flink.runtime.operators.sort.LargeRecordHandler.finishWriteAndSortKeys(LargeRecordHandler.java:263)
  at org.apache.flink.runtime.operators.sort.UnilateralSortMerger$SpillingThread.go(UnilateralSortMerger.java:1409)
  at org.apache.flink.runtime.operators.sort.UnilateralSortMerger$ThreadBase.run(UnilateralSortMerger.java:796)
Caused by: java.io.IOException: Thread 'SortMerger Reading Thread' terminated due to an exception: tried to access field com.esotericsoftware.kryo.io.Input.inputStream from class org.apache.flink.api.java.typeutils.runtime.NoFetchingInput
  at org.apache.flink.runtime.operators.sort.UnilateralSortMerger$ThreadBase.run(UnilateralSortMerger.java:799)
Caused by: java.lang.IllegalAccessError: tried to access field com.esotericsoftware.kryo.io.Input.inputStream from class org.apache.flink.api.java.typeutils.runtime.NoFetchingInput
  at org.apache.flink.api.java.typeutils.runtime.NoFetchingInput.readBytes(NoFetchingInput.java:122)
  at com.esotericsoftware.kryo.io.Input.readBytes(Input.java:297)
  at com.esotericsoftware.kryo.serializers.DefaultArraySerializers$ByteArraySerializer.read(DefaultArraySerializers.java:35)
  at com.esotericsoftware.kryo.serializers.DefaultArraySerializers$ByteArraySerializer.read(DefaultArraySerializers.java:18)
  at com.esotericsoftware.kryo.Kryo.readObjectOrNull(Kryo.java:706)
  at com.esotericsoftware.kryo.serializers.FieldSerializer$ObjectField.read(FieldSerializer.java:611)
  at com.esotericsoftware.kryo.serializers.FieldSerializer.read(FieldSerializer.java:221)
  at com.esotericsoftware.kryo.Kryo.readClassAndObject(Kryo.java:732)
  at org.apache.flink.api.java.typeutils.runtime.kryo.KryoSerializer.deserialize(KryoSerializer.java:228)
  at org.apache.flink.api.java.typeutils.runtime.kryo.KryoSerializer.deserialize(KryoSerializer.java:242)
  at org.apache.flink.api.java.typeutils.runtime.TupleSerializer.deserialize(TupleSerializer.java:144)
  at org.apache.flink.api.java.typeutils.runtime.TupleSerializer.deserialize(TupleSerializer.java:30)
  at org.apache.flink.api.java.typeutils.runtime.TupleSerializer.deserialize(TupleSerializer.java:144)
  at org.apache.flink.api.java.typeutils.runtime.TupleSerializer.deserialize(TupleSerializer.java:30)
  at org.apache.flink.runtime.io.disk.InputViewIterator.next(InputViewIterator.java:43)
  at org.apache.flink.runtime.operators.sort.UnilateralSortMerger$ReadingThread.go(UnilateralSortMerger.java:973)
  at org.apache.flink.runtime.operators.sort.UnilateralSortMerger$ThreadBase.run(UnilateralSortMerger.java:796)
```

### Work-around
I've switched from using Tuple2 to a Protocol Buffer message:
```
message KeyDay {
  optional ByteString key = 1;
  optional int64 timestamp_usec = 2;
}
```

But using `Tuple2.of()` was just easier than: `KeyDay.newBuilder().setKey(...).setTimestampUsec(...).build()`.
