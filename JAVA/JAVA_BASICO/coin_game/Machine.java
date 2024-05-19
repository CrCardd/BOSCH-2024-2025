import java.util.Random;

public class Machine
{
    public void round(Person player1, Person player2)
    {
        if(player1.coop() && player2.coop())
        {
            player1.addCoins(2);
            player2.addCoins(2);
        } else if(!player1.coop() && player2.coop())
        {
            player1.addCoins(4);
            player2.addCoins(0);
        } else if( player1.coop() && !player2.coop())
        {
            player1.addCoins(0);
            player2.addCoins(4);
        }
        player1.calc(player2.coop());
        player2.calc(player1.coop());
    }

    public boolean endOfRound(Person player)
    {
        Random rand = new Random();
        player.addCoins(0);
        player.addCoins((rand.nextInt(10) == 1) ? 0 : 1);
        return player.getCoin() < 1;
    }
}