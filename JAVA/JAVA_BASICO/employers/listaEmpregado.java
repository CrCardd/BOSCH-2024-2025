public class listaEmpregado{

    private noEmpregado head = null;
    private int size = 0;

    public void add( Empregado empregado ){
        size++;
        noEmpregado node = new noEmpregado(empregado);
        if( head == null ){
            head = node;
            return;
        }

        noEmpregado atual = head;
        while(atual.getNext() != null ){
            atual = atual.getNext();
        }
        atual.setNext(node);
    }




    private Empregado getIndex( int index ){
        int count = 0;
        noEmpregado atual = head;
        while( count != index && atual != null){
            atual = atual.getNext();
            count++;
        }
        return atual == null ? null : atual.getValue();
    }

    public int getSize(){
        return this.size;
    }

    public Empregado listCompare( Empregado user, listaEmpregado lista ){
        Empregado check = null;
        for( int i = 0 ; i < lista.getSize() ; i ++ ){
            check = lista.getIndex(i);
                if( check.getCpf().equals(user.getCpf()) && check.getPassword().equals(user.getPassword())){
                    return check;
                }
            }

        return null;
    }

    public String listarEmpregados ( listaEmpregado lista, int index ){
        return lista.getIndex(index).getName() + "\t-   " + lista.getIndex(index).getCpf();
    }
    
}