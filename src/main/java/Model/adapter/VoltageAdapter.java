package Model.adapter;

/**
 * 变压器
 */
public class VoltageAdapter {

    public void changeVoltage(){
        System.out.println("正在充电...");
        System.out.println("原始电压: " +Phone.V + "V");
        System.out.println("经过变压器转换后的电压:" + (Phone.V - 200) + "V");
    }

}
