abstract class Person 
{
    Person( String name )
    {
        this.playerName = name;
    }

    private Integer coins = 10;
    private String playerName;

    abstract boolean coop();
    abstract void calc(boolean value);
    abstract Person copy();
    abstract public void incrementCount();
    abstract public void decrementCount();



    public void addCoins(Integer value)
    {
        this.coins -=1;
        this.coins += (value);
    }

    public Integer getCoin()
    {
        return this.coins;
    }

    public void setCoin(Integer value)
    {
        this.coins = value;
    }


    public String getName()
    {
        return this.playerName;
    }



    




}
