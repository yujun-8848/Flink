package Model.strategy;

public class Sort implements ISort {

    private ISort sort;

//    public Sort(ISort sort) {
//        this.sort = sort;
//    }

    public Sort(SortStrategy strategy){
        setStrategy(strategy);
    }
    @Override
    public void sort(int[] arr) {
        sort.sort(arr);
    }

    /**
     * 使用枚举来封装各种策略
     * @param strategy
     */
    public void setStrategy(SortStrategy strategy){
        switch (strategy){
            case BUBBLE_SORT:
                sort = new BubbleSort();
                break;
            case INSERT_SORT:
                sort = new InsertSort();
                break;
            case SELECTION_SORT:
                sort = new SelectionSort();
                break;
            default:
                break;
        }
    }
}
