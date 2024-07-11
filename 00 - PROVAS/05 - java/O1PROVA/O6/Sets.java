package O6;

public class Sets<T> {
    
    public static IntersectionSet intersect (Set set1, Set set2){
        return new IntersectionSet(set1,set2);
    }
}   
