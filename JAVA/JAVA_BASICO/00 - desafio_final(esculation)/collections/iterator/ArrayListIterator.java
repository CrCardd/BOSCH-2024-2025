package collections.iterator;

import collections.*;
import collections.exceptions.CheckedException;

public class ArrayListIterator<E> implements Iterator<E> {

    private ArrayList<E> array;
    private Integer step = -1;

    public ArrayListIterator(ArrayList<E> array) {
        this.array = array;
    }

    @Override
    public E next() throws CheckedException {
        
        if(hasNext())
        {
            this.step++;
            return this.array.get(step);
        }
        
        throw new CheckedException("nao tem mais filhao");
        
    }
    
    @Override
    public boolean hasNext() {
        if(this.array != null)
            return (array.get(step + 1) == null) ? false : true;
        throw new CheckedException("array vazio filhao");
        
    }
}
