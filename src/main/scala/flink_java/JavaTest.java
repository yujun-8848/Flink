package flink_java;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.common.functions.JoinFunction;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.operators.DataSource;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.api.java.tuple.Tuple3;
import org.apache.flink.api.java.tuple.Tuple4;
import org.apache.flink.util.Collector;

import java.util.ArrayList;
import java.util.List;

public class JavaTest {

    public static void main(String[] args) throws Exception {

        ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();
        DataSource<String> source = getCollection(env);
        source.flatMap(new FlatMapFunction<String, String>() {
            @Override
            public void flatMap(String s, Collector<String> collector) throws Exception {
                String[] split = s.split(",");
                for (String s1 : split) {
                    collector.collect(s1);
                }
            }
        }).map(new MapFunction<String, Tuple2<String, Integer>>() {
            @Override
            public Tuple2<String, Integer> map(String s) throws Exception {
                return new Tuple2<>(s, 1);
            }
        }).groupBy(0).sum(1).print();
        join(env);

    }

    public static DataSource<String> getCollection(ExecutionEnvironment env) {
        List<String> list = new ArrayList<>();
        list.add("123,123");
        list.add("234,2");
        list.add("123,1");
        list.add("2,2");
        return env.fromCollection(list);
    }

    public static void join(ExecutionEnvironment env) throws Exception {
        List<Tuple2<Integer,String>> list = new ArrayList<>();
        list.add(new Tuple2<>(1, "uzi"));
        list.add(new Tuple2<>(2, "xiaohu"));
        list.add(new Tuple2<>(3, "ming"));
        list.add(new Tuple2<>(4, "long"));

        List<Tuple2<Integer,String>> list2 = new ArrayList<>();
        list2.add(new Tuple2<>(1, "ADC"));
        list2.add(new Tuple2<>(4, "Mid"));
        list2.add(new Tuple2<>(4, "jug"));

        DataSource<Tuple2<Integer, String>> source = env.fromCollection(list);
        DataSource<Tuple2<Integer, String>> source1 = env.fromCollection(list2);

        source.leftOuterJoin(source1).where(0).equalTo(0).with(new JoinFunction<Tuple2<Integer, String>, Tuple2<Integer, String>, Tuple4<Integer,String,Integer,String>>() {
            @Override
            public Tuple4<Integer, String, Integer, String> join(Tuple2<Integer, String> first, Tuple2<Integer, String> second) throws Exception {
                if(second == null){
                    return new Tuple4<>(first.f0,first.f1,0,"-");
                }
                return new Tuple4<>(first.f0,first.f1,second.f0,second.f1);
            }
        }).print();

    }
}
