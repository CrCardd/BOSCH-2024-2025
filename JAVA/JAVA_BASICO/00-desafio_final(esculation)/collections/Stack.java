package collections;

import collections.exceptions.CheckedException;
import collections.iterator.StackIterator;
import collections.iterator.Iterable;
import collections.iterator.Iterator;

public class Stack<T> extends Origin implements Iterable<T>
{
    private T[] stack;

    @SuppressWarnings("unchecked")
    public Stack()
    {
        stack = (T[])(new Object[10]);
    }
    
    @SuppressWarnings("unchecked")
    public Stack( int capacity )
    {
        stack = (T[])(new Object[capacity]);
    } 

    public void push(T value)
    {   
        if ( size == stack.length )
        {
            @SuppressWarnings("unchecked")
            T[] copy = (T[])( new Object[ stack.length * 2 ]);

            for( int i = 0 ; i < size ; i++ )
            {
                copy[i] = this.stack[i];
            }
        
        stack = copy;
        }

        this.stack[size] = value;
        this.size++;
    }

    public T get(int index)
    {   
        if(index >= this.size)
            throw new CheckedException("Indice grandao parça (stack)");
        return this.stack[index];
    }

    public void set(int index, T value)
    {
        if(index >= this.size)
            throw new CheckedException("Indice grandao parça (stack)");
        this.stack[index] = value;
    }

    public void pop(){

        if (this.size == 0) 
            return;   
        
        this.size--;
    }        

    public T peek(){
        if(this.size == 0)
            return null;
        
        return stack[size - 1];

    }

    @Override
    public Iterator<T> iterator() {
        return new StackIterator<T>(this);
    }

    @Override
    public Stream<T> stream() {
        return new Stream<>(this);
    }
}
