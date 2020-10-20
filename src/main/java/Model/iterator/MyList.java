package Model.iterator;

import java.util.Arrays;
import java.util.List;

public class MyList {

    private List<String> data = Arrays.asList("a","b","c");

    //每次生成一个新的迭代器，用于遍历列表
    public Iterator iterator(){
        return new Itr();
    }

    private class Itr implements Iterator{

        private int index = 0;
        @Override
        public boolean hasNext() {
            return index < data.size();
        }

        @Override
        public String next() {
            return data.get(index++);
        }
    }
}
