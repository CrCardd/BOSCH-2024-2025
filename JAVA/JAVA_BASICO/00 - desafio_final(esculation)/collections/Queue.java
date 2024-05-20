package collections;

import collections.exceptions.CheckedException;

public class Queue<T> extends Origin {

    private Node <T>head = null;
    private Node <T>tail = null;

    public void enqueue(T value)
    {
        Node<T> node = new Node<>(value);
        if(head == null) {
            this.head = node;
            this.tail = node;
            this.size++;
            return;
        }
        tail.setNext(node);
        node.setPrevious(tail);
        tail = node;
        this.size++;
    }

    // Retirar primeiro item da fila
    public T dequeue() 
    {

        if (this.head == null) {
            throw new CheckedException("Fila vazia amigão, sinto muito.");
        }

        T aux = head.getValue();
        this.head = this.head.getNext();

        if(this.head != null ) {
            this.head.setPrevious(null);
        }    
        this.size--;
        return aux;
    }

    public Node<T> getHead(){
        return this.head;
    }
}


