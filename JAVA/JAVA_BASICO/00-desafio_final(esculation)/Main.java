// import collections.iterator.*;
import java.util.Random;

import collections.*;
import collections.iterator.*;
import collections.iterator.Iterable;

public class Main {
    public static void main(String[] args) {
        int DEBUG = 210;
        LinkedList<Integer> linkedlist = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new Queue<>();
        Hash<Integer> hash = new Hash<>();
        ArrayList<Integer> arraylist = new ArrayList<>();

        for(int i = 0; i < DEBUG; i++)
        {
            linkedlist.add(i);
            stack.push(i);
            queue.enqueue(i);
            hash.add(i);
            arraylist.add(i);
        }

        Iterable<Integer> iterable = null;
        for(int i=0; i<5; i++){
            switch (i){//new Random().nextInt(5)) {
                case 0:
                System.err.println("\n\nLINKEDLIST");
                iterable = linkedlist;
                break;
                case 1:
                System.err.println("\n\nSTACK");
                iterable = stack;
                break;
                case 2:
                System.err.println("\n\nQUEUE");
                iterable = queue;
                break;
                case 3:
                System.err.println("\n\nHASH");
                iterable = hash;
                break;
                default:
                System.err.println("\n\nARRAYLSIT");
                iterable = arraylist;
                break;
            }

            Iterator<Integer> iterator = iterable.iterator();
            while(iterator.hasNext()){
                System.err.println(iterator.next());
            }
        }
        // Iterable<String> result = iterable
        //     .stream()
        //     .map(i -> i.toString())
        //     .filter(s -> s.length() == 2)
        //     .collect();

        // System.err.println("\n\n\n");

        // Iterator<String>iterator = result.iterator();
        // while(iterator.hasNext()){
        //     System.err.println(iterator.next());
        // }
    }
}
