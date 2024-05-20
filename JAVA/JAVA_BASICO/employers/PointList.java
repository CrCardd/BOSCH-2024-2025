public class PointList {
    Point head = null;
    int size = 0;
    public void add( Point point )
    {
        size++;
        if(head == null ){
            head = point;
            return;
        }
        Point atual = head;
        while(atual.getNext() != null ){
            atual = atual.getNext();
        }
        atual.setNext(point);
    }

    private Point getPoint( int index )
    {
        Point atual = head;
        int count = 0;
        while( atual.getNext() != null && count != index )
        {
            atual = atual.getNext();
            count++;
        }
        return atual;
    }

    public String searchEmployer( int index, String cpf )
    {
        Point point = getPoint(index);
        if( cpf.equals(point.getCpf())){
            return point.getCpf() + " | " + point.getHour() + ":" + point.getMinute() + " | " + point.getDay() + "/" + point.getMonth();
        }
        return null;
    }

    public int getSize()
    {
        return this.size;
    }

}
