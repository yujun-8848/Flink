package flink_java;

import lombok.AllArgsConstructor;
import lombok.Data;
@AllArgsConstructor
@Data
public class SensorRending {

    //id: String, timeStemp: Long, temprtra: Double
    private String id;
    private Long timeStemp;
    private Double temprtra;
}
