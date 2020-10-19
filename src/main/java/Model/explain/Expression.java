package Model.explain;

/**
 * 解释器模式：给定一门语言，定义它的文法的一种表示，并定义一个解释器，该解释器使用该
 * 表示来解释语言中的句子。
 */
public interface Expression {
    int intercept();
}
