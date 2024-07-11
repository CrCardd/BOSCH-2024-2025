import java.util.Random;
import java.util.Scanner;

public class O7 {

    public static double PI(Integer quantity){
        Random rand = new Random();
        Float x,y;
        Integer r,b;
        r = 0;
        b = 0;
        for(int i=0; i< quantity ; i++){
            x = rand.nextFloat();
            y = rand.nextFloat();
                
            if(Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)) < 1)
                r++;
            else
                b++;
        }
        return ((double)4 * r / (r+b));
    }


    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.err.print("\n\nType how many points for the simulation:\n>>>  ");
        Integer points;

        try{
            points = scan.nextInt();
            scan.nextLine();
            System.err.println("\n\nPI\t~~\t" + PI(points));

        } catch(Exception e){
            System.err.println("\n\nInvalid, please type a valid number!\n\n\n");
    

        
        scan.close();
        }

    }
}
