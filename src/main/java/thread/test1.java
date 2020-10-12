package thread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class test1 {

    public static void main(String[] args) {

        AtomicInteger i = new AtomicInteger(1);
        i.updateAndGet(operand ->
                operand * 10
        );
        System.out.println(i.get());
        demo(() -> new int[10],
                (array) -> array.length,
                System.out::println);

    }

    public static <T> void demo(Supplier<T> supplier, Function<T, Integer> function, Consumer<T> consumer) {
        T t = supplier.get();
        Integer apply = function.apply(t);
        consumer.accept(t);
    }
}
