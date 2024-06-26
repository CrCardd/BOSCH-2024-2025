package collections;

import collections.exceptions.CheckedException;

public class Hash<T> extends Origin
{
    ArrayList<T>[] hash;
    private Integer capacity = 0;
    private Integer elements = 0;

    @SuppressWarnings("unchecked")
    public Hash(){
        this.capacity = 10;
        this.hash = (ArrayList<T>[])(new ArrayList[capacity]);
        for(int i=0; i<this.capacity; i++){
            hash[i] = new ArrayList<T>();
        }
    }
    
    @SuppressWarnings("unchecked")
    public Hash(Integer capacity){
        this.hash = (ArrayList<T>[])(new ArrayList[capacity]);
        this.capacity = capacity;
        for(int i=0; i<this.capacity; i++){
            hash[i] = new ArrayList<T>();
        }
    }

    public void add(T value){

        if(((this.elements * 100)/ this.capacity) / this.capacity >= 70){
            this.capacity *= 2;
            @SuppressWarnings("unchecked")
            ArrayList<T>[] copy = (ArrayList<T>[])(new ArrayList[capacity]);
            for(int i=0; i<this.capacity; i++){
                copy[i] = new ArrayList<T>();
            }
            
            for(int i=0; i<hash.length; i++){
                for(int j=0; j<hash[i].getSize(); j++){
                    Integer index_copy = Math.abs((hash[i].get(j).hashCode()) % capacity); 
                    copy[index_copy].add(hash[i].get(j));
                }
            }
            this.hash = copy;
        }

        Integer index = Math.abs(value.hashCode()%(capacity)); 
        hash[index].add(value);
        this.elements++;
    }

    public T get(T value){
        Integer index = Math.abs(value.hashCode()%capacity);
        for (int i=0; i<hash[index].getSize(); i++){
            if(hash[index].get(i).equals(value)){
                return hash[index].get(i);
            }
        }
        throw new CheckedException("Indice inválido paizao");
    }
    public T getByIndex(Integer value){
        Integer index = Math.abs(value%capacity);
        for (int i=0; i<hash[index].getSize(); i++){
            if(hash[index].get(i).equals(value)){
                return hash[index].get(i);
            }
        }
        throw new CheckedException("Indice inválido paizao");
    }
}