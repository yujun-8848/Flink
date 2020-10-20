package Model.iterator;

/**
 * 迭代器模式：提供一种方法访问一个容器对象中各个元素，而又不需要暴露
 * 该对象的内部细节。
 */
public interface Iterator {
    boolean hasNext();
    String next();
}
