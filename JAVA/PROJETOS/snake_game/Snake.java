public class Snake <T>{

    private Node<T> head = null;
    private Node<T> tail = null;
    private Integer size = null;


    public Snake(T food){
        this.size = 2;
        this.push(food);
        this.push(food);
    }


    public void push(T render_value)
    {
        Node<T> new_node = new Node<T>(render_value);
        if(this.head == null){
            this.head = new_node;
            this.tail = new_node;
            this.size++;
            return;
        }
        this.tail.setNext(new_node);
        new_node.setPrev(this.tail);
        this.tail = new_node;
    }




    public void go(Direction direction){

        Node<T> current_node = this.head;

        this.head.updatePosition_x(direction.getPosition_x());
        this.head.updatePosition_y(direction.getPosition_y());

        while(current_node.getNext() != null){
            current_node.getNext().setPosition_x(current_node.getPosition_x());
            current_node.getNext().setPosition_y(current_node.getPosition_y());
        }
    }




    public void grow(T food){
        push(food);

    }


    
    public void Eat(T food){
        grow(food);

    }




}