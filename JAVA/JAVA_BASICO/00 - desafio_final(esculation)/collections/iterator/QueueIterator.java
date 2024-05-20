package collections.iterator;

import collections.*;
import collections.exceptions.*;

public class QueueIterator<E> implements Iterator<E>{

    private Queue<E> queue;
    private Node<E> current;
    private Integer step = -1;

    public QueueIterator(Queue<E> queue) {
        this.queue = queue;
    }

    @Override
    public E next() throws CheckedException {
        
        step++;

        if (step == 0) {
            current = queue.getHead();
            return current.getValue();
        }

        if (current.getNext() != null) {
            current = current.getNext();
            step++;
            return current.getValue();
        }

        throw new CheckedException("Lista vazia amigão sinto muito.");
    }

    @Override
    public boolean hasNext() {
        if(this.queue != null)
            return (current.getNext() != null) ? true : false; 
        throw new CheckedException("Lista vazia amigão, sinto muito.");
    }
}
