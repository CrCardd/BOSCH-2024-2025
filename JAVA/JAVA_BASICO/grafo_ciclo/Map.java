import java.util.ArrayList;

public class Map {

    Stack<ArrayList<Integer>> list = new Stack<>();
    
    public void addWay( Integer index, ArrayList<Integer> way)
    {
        list.push(index,way);
    }
}
