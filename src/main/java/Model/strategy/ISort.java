package Model.strategy;

/**
 * 策略模式：定义了一系列算法，并将每一个算法封装起来，而且使它们还可以
 * 相互依赖。策略模式让算法独立于使用它的客户而独立变化
 */
public interface ISort {

    void sort(int[] arr);

}
