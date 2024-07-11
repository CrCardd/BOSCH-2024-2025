package O8;

public class Vagao {

    private TrainContent value;
    private Vagao next = null;
    private Vagao previous = null;

    
    public Vagao(TrainContent value) {
        
        this.value = value;
    }
    
    public TrainContent getValue() {
        
        return value;
    }
    public void setValue(TrainContent value) {
        
        this.value = value;
    }
    public Vagao getNext() {
        
        return next;
    }
    public void setNext(Vagao next) {
        
        this.next = next;
    }
    
    public Vagao getPrevious() {
        return previous;
    }

    public void setPrevious(Vagao previous) {
        this.previous = previous;
    }

}
