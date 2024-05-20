// import collections.iterator.*;
import collections.*;

public class Main {



    public static void main(String[] args) {
        int DEBUG = 20;


        LinkedList<Integer> linkedlist = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new Queue<>();
        Hash<Integer> hash = new Hash<>();

        for(int i = 0; i < DEBUG; i++)
        {
            linkedlist.add(i);
            stack.push(i);
            queue.enqueue(i);
            hash.add(i);
        }

        // Linked List 
        for(int i = 0; i < DEBUG; i++)
        {
            System.out.println(linkedlist.get(i));
        }

        //STACK & QUEUE
        System.out.println("\n\n\nSTACK\t|\tQUEUE");
        for(int i = 0; i < DEBUG; i++) {
            System.out.println(stack.peek() + "\t|\t" + queue.dequeue());
            stack.pop();
        }

        //HASH
        System.err.println("\n\nHASH");
        for(int i=0; i<DEBUG; i++){
            System.out.println(hash.get(i));
        }
    }

    

}
