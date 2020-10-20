package Model.iterator;

import java.util.Iterator;
import java.util.List;

public class MyList2 implements Iterable<String> {
    private List<String> data;

    public MyList2(List<String> data) {
        this.data = data;
    }

    @Override
    public Iterator<String> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<String> {

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
