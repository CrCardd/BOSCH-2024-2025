package O6;

import java.util.Iterator;

public class IntersectionSet extends Set {
    Set set1;
    Set set2;
    IntersectionSet(Set set1, Set set2){
        this.set1 = set1;
        this.set2 = set2;
        if(set1 == null || set2 == null)
            return;
        Iterator<Double> iterator = set1.hash.iterator();

        while(iterator.hasNext()){
            Double next = iterator.next();
            if(set2.contains(next)){
                addHash(next);
            }
        }
    }

    
}
