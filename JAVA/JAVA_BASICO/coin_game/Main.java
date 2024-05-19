public class Main
{
    public static void main(String[] args)
    {
       
        int cheaters = 50;
        int collaboratives = 50;
        int copycats = 50;
        int grumpys = 50;
        int tolerants = 50;

        World world = new World(grumpys, collaboratives, cheaters, tolerants, copycats);
        world.game();
    }
}