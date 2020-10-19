package Model.builder;

/**
 * 建造者模式用于创建过程中稳定，但配置多变的对象。
 * 将一个复杂的构建与其表示相分离，使得同样的构建过程可以创建不同的表示。
 * 现在建造者模式主要用来通过链式调用生成不同的配置。
 * 比如制作一杯珍珠奶茶，它的制作过程是稳定的，除了必须要知道奶茶的种类和规格外，
 * 是否加珍珠和是否加冰是可选的
 */
public class MilkTea {

    private final String type;
    private final String size;
    private final boolean pearl;
    private final boolean ice;

    private MilkTea(Builder builder) {
        this.ice = builder.ice;
        this.pearl = builder.pearl;
        this.type = builder.type;
        this.size = builder.size;
    }

    public String show() {
        StringBuilder sb = new StringBuilder();
        if(ice){
            sb.append("加冰").append("的");
        }else {
            sb.append("不加冰").append("的");
        }
        if(pearl){
            sb.append("加珍珠").append("的");
        }else {
            sb.append("不加珍珠").append("的");
        }
        sb.append(size).append("的").append(type).append("奶茶");
        return sb.toString();
    }

    static class Builder {
        private String type;
        private String size = "小杯";
        private boolean pearl;
        private boolean ice;

        public Builder(String type) {
            this.type = type;
        }

        public Builder size(String size) {
            this.size = size;
            return this;
        }

        public Builder pearl(boolean pearl) {
            this.pearl = pearl;
            return this;
        }

        public Builder ice(boolean ice) {
            this.ice = ice;
            return this;
        }

        public MilkTea build() {
            return new MilkTea(this);
        }
    }
}
