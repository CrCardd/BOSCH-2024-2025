class Collaborative extends Person
{
    public static int count = 0;

    Collaborative(String name)
    {
        super(name);
        Collaborative.count++;
    }

    @Override
    public boolean coop()
    {
        return true;
    }

    @Override
    public void calc(boolean value){}

    @Override
    public Person copy()
    {
        Person clone = new Collaborative(getName());
        return clone;
    }


    @Override
    public void incrementCount()
    {
        Collaborative.count++;
    }

    @Override
    public void decrementCount()
    {
        Collaborative.count--;
    }

    
    public static int getCount()
    {
        return Collaborative.count;
    }

    public static int getCountBool()
    {   
        return (Collaborative.count < 1) ? 0 : 1; 
    }
}
