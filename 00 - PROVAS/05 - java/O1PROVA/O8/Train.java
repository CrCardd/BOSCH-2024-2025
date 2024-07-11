package O8;

public class Train{
    
    private Integer size = 0;

    private Vagao head = null;
    private Vagao tail = null;
    
    public void add(TrainContent value) {
    
        Vagao newVagao = new Vagao(value);
        this.size++;
    
        if (head == null) {
            head = newVagao;
            tail = head;
            return;
        }
    
        newVagao.setPrevious(tail);
        tail.setNext(newVagao);
        tail = newVagao;
    }

    
    public Integer count(TrainContent type){
        Vagao current = this.head;
        Integer quantity = 0;
        if(current == null)
            return quantity;

        do{
            if(current.getValue() == type)
                quantity++;
            current = current.getNext();
        } while(current != null);

        return quantity;
    }


}   
