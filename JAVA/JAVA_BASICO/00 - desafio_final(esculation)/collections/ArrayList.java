package collections;

public class ArrayList<T> extends List<T>// implements Iterable<T>
{

    private T[] data;

    @SuppressWarnings("unchecked")
    public ArrayList()
    {
        data = (T[])(new Object[10]);
    }
    
    @SuppressWarnings("unchecked")
    public ArrayList( int capacity )
    {
        data = (T[])(new Object[capacity]);
    } 

    @Override
    public void add(T value)
    {   
        if ( size == data.length )
        {
            @SuppressWarnings("unchecked")
            T[] copy = (T[])( new Object[ data.length * 2 ]);

            for( int i = 0 ; i < size ; i++ )
            {
                copy[i] = this.data[i];
            }
        
        data = copy;
        }

        this.data[size] = value;
        this.size++;
    }

    @Override
    public T get(int index)
    {
        return this.data[index];
    }

    @Override
    public void set(int index, T value)
    {
        this.data[index] = value;
    }

    // @Override
    // Iterator<T> iterator() {
    //     ArrayListIterator<T> array = new ArrayListIterator<T>(this);
    //     return array;
    // }
    
}
