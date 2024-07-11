package O8;

public class Main {
    public static void main(String[] args) {
        Train train = new Train();
        for(int i = 0; i < 200; i++){
            train.add(TrainContent.COMBUSTIVEL);
        }
        System.err.println("\n\n");
        System.err.println(train.count(TrainContent.TRIGO));
    }
}
