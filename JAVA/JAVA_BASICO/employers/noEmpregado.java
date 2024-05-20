public class noEmpregado{



    private Empregado value;
    private noEmpregado next = null;

    public noEmpregado(Empregado value) {
        this.value = value;
    }

    public Empregado getValue() {
        return value;
    }

    public noEmpregado getNext() {
        return next;
    }
    
    public void setNext(noEmpregado next) {
        this.next = next;
    }


}