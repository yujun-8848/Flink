package Model.strategy;

public class Test {

    public static void main(String[] args) {

       // Sort sort = new Sort(new SelectionSort());
        Sort sort = new Sort(SortStrategy.INSERT_SORT);
        sort.sort(new int[]{});

    }
}
