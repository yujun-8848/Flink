package Model.template;

/**
 * 模板模式：定义一个操作中的算法骨架，而将一些步骤延迟到子类中。
 * 模板方法使得子类可以不改变一个算法的结构即可重定义该算法的某些特定步骤
 * 以请假为例子
 * 本人__因__需请假__天，望批准！
 */
public abstract class LeaveRequest {

    void request(){
        System.out.println("本人");
        System.out.println(name());
        System.out.println("因");
        System.out.println(reason());
        System.out.println("需请假");
        System.out.println(duration());
        System.out.println("天，望批准");
    }
    abstract String name();
    abstract String reason();
    abstract String duration();
}
