package O5;

import java.util.Random;

public class Crazy extends Person{
    public boolean decision(){
        Random rand = new Random();
        return ((rand.nextInt(2)&1) == 1);
    }
}