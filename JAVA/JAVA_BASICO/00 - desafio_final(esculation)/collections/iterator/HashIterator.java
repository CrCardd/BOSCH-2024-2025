package collections.iterator;
import collections.*;
import collections.exceptions.CheckedException;

public class HashIterator<T> implements Iterator<T>{
    private Hash<T> hash;
    private Integer step = -1;

    public HashIterator(Hash<T> hash){
        this.hash = hash;
    }

    @Override
    public T next(){
        if(this.hash != null){
            if(hasNext()){
                step++;
                return hash.getByIndex(step);
            }
            throw new CheckedException("tem próximo nao doido");
        }
        throw new CheckedException("hash vazio filhao");
    }
    
    @Override
    public boolean hasNext(){
        if(hash != null)
            return (this.hash.getByIndex(step+1) == null) ? false : true; 
        throw new CheckedException("hash vazio filhao");
    }


    
}
