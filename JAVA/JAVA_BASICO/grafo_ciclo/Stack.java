public class Stack<T>
{
    // push pop peek size
    // array dinamico
    T[] data;
    Integer size = 0;
    Stack()
    {
        data = (T[])(new Object[10]);
    }
    
    Stack( int capacity )
    {
        data = (T[])(new Object[capacity]);
    }

    public void push(Integer index, T value)
    {


        if ( index >= data.length )
        {
            T[] copy = (T[])( new Object[ index+1 ]);
            for( int i = 0 ; i < size ; i++ )
            {
                copy[i] = this.data[i];
            }
        }
        this.data[index] = value;
        System.err.println(index);
        System.out.println(value);
        System.out.print("\n\n\n");
        this.size++;
    }

    public void pop(){
        this.data[this.size] = null;
        this.size--;
    }

    public T peek()
    {
        return this.data[this.size];
    }

    public Integer getSize()
    {   
        return this.size;    
    }
}
