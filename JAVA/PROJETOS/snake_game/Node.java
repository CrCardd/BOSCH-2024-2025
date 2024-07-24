public class Node <T>{

    private T render_value;

    private Integer position_x;
    private Integer position_y;

    private Node<T> next;
    private Node<T> prev;





    public Node(T render_value){
        this.render_value = render_value;
    }


    public T getRender_value() {
        return render_value;
    }
    public void setRender_value(T render_value) {
        this.render_value = render_value;
    }
    public Node<T> getNext() {
        return next;
    }
    public void setNext(Node<T> next) {
        this.next = next;
    }
    public Node<T> getPrev() {
        return prev;
    }
    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }



    
    
    public void setPositions_yx(Integer y, Integer x) {
        this.position_y = y;
        this.position_x = x;
    }

    public void updatePosition_x(Integer add_x) {
        this.position_x +=  add_x;
    }
    public void updatePosition_y(Integer add_y) {
        this.position_y = add_y;
    }



    public Integer getPosition_y() {
        return position_y;
    }
    public Integer getPosition_x() {
        return position_x;
    }
    
    
}
