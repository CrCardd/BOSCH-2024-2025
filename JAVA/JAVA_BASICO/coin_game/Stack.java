public class Stack {
    
    private Person[] stack = null;
    private Integer size;
    Stack(Integer grumpys, Integer collaboratives, Integer cheaters, Integer tolerants, Integer copycats)
    {

        Person[] everyone = new Person[grumpys + collaboratives + cheaters + tolerants+copycats];
        int j=0,i=0;
        for(; i < grumpys ; i++)
            everyone[i] = new Grumpy("Grumpy");
        j+=grumpys;
        for(; i < j+collaboratives ; i++)
            everyone[i] = new Collaborative("Collaborative");
        j+=collaboratives;
        for(; i < j+cheaters ; i++)
            everyone[i] = new Cheater("Cheater");
        j+=cheaters;
        for(; i < j+tolerants ; i++)
            everyone[i] = new Tolerant("Tolerant");
            j+=tolerants;
        for(; i < j+copycats ; i++)
            everyone[i] = new Copycat("Copycat");
        j+=copycats;
        this.stack = everyone;
        this.size = j;
    }


    public void addPlayer(Person player)
    {
        if(this.size == stack.length)
        {
            Person[] copy = new Person[stack.length*2];
            for(int i=0 ; i < stack.length ; i++)
            {
                copy[i] = stack[i];
            }
            this.stack = copy;
        }
        this.stack[size] = player;
        size++;
    }


    public Person getPlayer(Integer index)
    {
        return this.stack[index];
    }

    public void removePlayer(Integer index)
    {
        this.stack[index].decrementCount();
        this.stack[index] = this.stack[size-1];
        this.stack[size-1] = null;
        size--;
    }

    public Person[] getDinamicArray()
    {
        return stack;
    }

    public Integer getSize() 
    {
        return this.size;    
    }
}
