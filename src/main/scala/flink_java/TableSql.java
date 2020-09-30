package flink_java;

import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.table.api.DataTypes;
import org.apache.flink.table.api.EnvironmentSettings;
import org.apache.flink.table.api.Table;
import org.apache.flink.table.api.bridge.java.StreamTableEnvironment;
import org.apache.flink.table.descriptors.Csv;
import org.apache.flink.table.descriptors.FileSystem;
import org.apache.flink.table.descriptors.Schema;

import static org.apache.flink.table.api.Expressions.$;


public class TableSql {
    private static StreamExecutionEnvironment env;

    public static void main(String[] args) throws Exception {
        env = StreamExecutionEnvironment.getExecutionEnvironment();
        EnvironmentSettings fsSettings = EnvironmentSettings.newInstance().useOldPlanner().inStreamingMode().build();
        env.setParallelism(1);
        StreamTableEnvironment tEnv = StreamTableEnvironment.create(env, fsSettings);
        String path = "D:\\Flink\\src\\main\\resources\\sensor";
        table1(tEnv, path);
        //table2(tEnv, path);
        tEnv.execute("");
    }

    public static void table1(StreamTableEnvironment tEnv, String path) {
        DataStream<SensorRending> operator = env.readTextFile(path)
                .map(new MapFunction<String, SensorRending>() {
                    @Override
                    public SensorRending map(String value) throws Exception {
                        String[] split = value.split(",");
                        return new SensorRending(split[0], Long.parseLong(split[1]), Double.parseDouble(split[2]));
                    }
                });
        //tEnv.createTemporaryView("table1",operator,$("id"), $("timeStemp"), $("temprtra"));
        Table table = tEnv.fromDataStream(operator);
        Table table1 = table.select($("id"), $("timeStemp"))
                .filter($("id").isEqual("sensor_1"));
        //TupleTypeInfo<Tuple> info = new TupleTypeInfo<>(Types.STRING(), Types.LONG(), Types.DOUBLE());
        tEnv.toAppendStream(table1, SensorRending.class).print();

    }

    public static void table2(StreamTableEnvironment tEnv, String path) {
        //定义表字段类型
        Schema schema = new Schema();
        schema.field("id", DataTypes.STRING())
                .field("time", DataTypes.BIGINT())
                .field("temprtra", DataTypes.DOUBLE());

        //定义输入表
        tEnv.connect(new FileSystem().path(path))
                .withFormat(new Csv().fieldDelimiter(',').deriveSchema())
                .withSchema(schema).createTemporaryTable("inputTable");
        //注册表
        Table table = tEnv.from("inputTable");
        Table resultTable = table
                .select($("id"), $("temprtra"))
                .filter($("id").isEqual("sensor_2"));

//        TupleTypeInfo<Tuple3<String, Long, Double>> info = new TupleTypeInfo<>(Types.STRING(), Types.LONG(), Types.DOUBLE());
//        //将表转换为stream
//        DataStream<Tuple3<String, Long, Double>> appendStream = tEnv.toAppendStream(table, info);
//        appendStream.print();

        //定义输出表
        Schema outSchema = new Schema();
        outSchema.field("id", DataTypes.STRING())
                .field("temprtra", DataTypes.DOUBLE());
        //定义输入表
        String outPath = "D:\\Flink\\src\\main\\resources\\outputTable";
        tEnv.connect(new FileSystem().path(outPath))
                .withFormat(new Csv().fieldDelimiter(',').deriveSchema())
                .withSchema(outSchema).createTemporaryTable("outputTable");
        //输出
        resultTable.executeInsert("outputTable");
    }
}
