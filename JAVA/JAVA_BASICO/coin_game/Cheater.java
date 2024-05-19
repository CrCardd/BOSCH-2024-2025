class Cheater extends Person 
{
    public static int count = 0;

    Cheater(String name)
    {
        super(name);
        Cheater.count++;
    }

    @Override
    public boolean coop(){
        return false;
    }

    @Override
    public void calc(boolean value){}

    @Override
    public Person copy()
    {
        Person clone = new Cheater(getName());
        return clone;
    }


    @Override
    public void incrementCount()
    {
        Cheater.count++;
    }

    @Override
    public void decrementCount()
    {
        Cheater.count--;
    }

    
    public static int getCount()
    {
        return Cheater.count;
    }

    public static int getCountBool()
    {   
        return (Cheater.count < 1) ? 0 : 1; 
    }
}
