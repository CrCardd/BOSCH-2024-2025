public class O3 {

    public static boolean check(int value){
        return (value&1) == 0;
    }

    public static void main(String[] args){
        System.out.println("\n\n" + check(5));
    }
}
