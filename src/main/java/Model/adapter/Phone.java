package Model.adapter;

/**
 * 适配器模式
 * 将两种完全不同的事物联系到一起，就像现实生活中的变压器。假设一个手机充电器
 * 需要的电压是20V，但是正常的电压是220V，这时候就需要一个变压器，将220V的电压
 * 转换成20V的电压，这样，变压器就将20V的电压和手机联系起来了
 */
public class Phone {
    //正常电压220V
    public static final int V = 220;

    private VoltageAdapter adapter;

    public void setAdapter(VoltageAdapter adapter) {
        this.adapter = adapter;
    }
    //充电
    public void charge(){
        adapter.changeVoltage();
    }
}
