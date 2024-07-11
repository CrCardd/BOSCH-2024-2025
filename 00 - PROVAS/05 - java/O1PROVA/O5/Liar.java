package O5;

import java.util.Random;

public class Liar extends Person{

    public void lieAge(){
        Random rand = new Random();
        setAge(rand.nextInt(50));
    }   
}
