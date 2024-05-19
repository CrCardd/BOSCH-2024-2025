class Copycat extends Person
{
    public static int count = 0;
    private boolean copycat=true;
    
    Copycat(String name)
    {
        super(name);
        Copycat.count++;
    }
    
    @Override
    public boolean coop()
    {
        return this.copycat;
    }

    @Override
    public void calc(boolean value)
    {
        this.copycat = value;
    }

    @Override
    public Person copy()
    {
        Person clone = new Copycat(getName());
        return clone;
    }


    @Override
    public void incrementCount()
    {
        Copycat.count++;
    }

    @Override
    public void decrementCount()
    {
        Copycat.count--;
    }

    public static int getCount()
    {
        return Copycat.count;
    }

    public static int getCountBool()
    {   
        return (Copycat.count < 1) ? 0 : 1; 
    }
}
