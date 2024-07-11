package O6;

import java.util.HashSet;
import java.util.Iterator;

public abstract class Set {

    protected HashSet<Double> hash = new HashSet<>();

    public void addHash(Double value){
        hash.add(value);
    }

    public boolean contains(Double value){
        Iterator<Double> iterator = hash.iterator();
        while(iterator.hasNext()){
            Double next = iterator.next();
            if(next == value){
                return true;
            }
        }
        return false;
    }

    
}
