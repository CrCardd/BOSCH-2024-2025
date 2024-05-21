package collections;
import java.util.function.Function;
import collections.iterator.*;
import collections.iterator.Iterable;

public class Stream<E> {

    private Iterable<E> iterable;
    private Iterator<E> iterator;
    public Stream(Iterable<E> iterable) {
        this.iterable = iterable;
    }
    
    public <R> Stream<R> map(Function<E, R> func) {
        ArrayList<R> new_database = new ArrayList<>();
        this.iterator = iterable.iterator();
        while(iterator.hasNext()){
            new_database.add(func.apply(iterator.next()));
        }
        return new Stream<>(new_database);
    }

    public Stream<E> filter(Function<E, Boolean> func) {
        this.iterator = iterable.iterator();
        ArrayList<E> new_database = new ArrayList<>();
        while(iterator.hasNext()){
            E next = iterator.next();
            if(func.apply(next))
                new_database.add(next);
        }
        return new Stream<>(new_database);
    }

    public List<E> collect() {
        return iterable;
    }
}
