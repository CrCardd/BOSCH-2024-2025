package collections.iterator;
import collections.*;
import collections.exceptions.CheckedException;

public class HashIterator<T> implements Iterator<T>{
    private ArrayList<T>[] hash;
    private Integer i = 0;
    private Integer j = -1;

    public HashIterator(ArrayList<T>[] hash){
        this.hash = hash;
    }

    @Override
    public T next(){
        if (!hasNext())
            throw new CheckedException("indice inválido paizão 1");
        
        ArrayList<T> list = this.hash[i];
        while (list == null && i < this.hash.length || j+1 >= hash[i].getSize()) {
            i++;
            j = -1;
            list = this.hash[i];
        }
        if (list == null)
            throw new CheckedException("indice inválido paizão 2");
        
        j++;
        return this.hash[i].get(j);
        
    }
    
    @Override
    public boolean hasNext(){
        return testNext(i, j);
    }

    private boolean testNext(Integer i, Integer j) {
        if (i >= hash.length)
            return false;
        ArrayList<T> list = this.hash[i];
        while (list == null && i < this.hash.length) {
            i++;
            j = -1;
            list = this.hash[i];
        }
        if (list == null)
            return false;
        
        j++;
        if (j < list.getSize())
            return true;
        
        return testNext(i + 1, -1);
    }
}
