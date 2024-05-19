import java.util.Random;

public class World 
{

    Stack allPlayers = null;

    World(Integer grumpys, Integer collaboratives, Integer cheaters, Integer tolerants, Integer copycats)
    {
        this.allPlayers = new Stack(grumpys, collaboratives, cheaters, tolerants, copycats);
        
    }

    public Person getPlayer(Integer index)
    {
        return allPlayers.getPlayer(index);
    }

    public void game()
    {
        Random rand = new Random();
        Machine machine = new Machine();
        Person player1=null,player2=null;
        int index,index2,rounds=0;
        while( Copycat.getCountBool() + Grumpy.getCountBool() + Tolerant.getCountBool() + Cheater.getCountBool() + Collaborative.getCountBool() != 1)
        {
            rounds+=1;
            for(int i = 0; i < allPlayers.getSize()/2; i++)
            {
                do
                {
                    index = rand.nextInt(this.allPlayers.getSize());
                    index2 = rand.nextInt(this.allPlayers.getSize());
                } while(index == index2);
                player1 = getPlayer(index);
                player2 = getPlayer(index2);

                
                if(player1.getCoin() >=20)
                {
                    allPlayers.addPlayer(player1.copy());
                    player1.setCoin(10);
                } else if (player1.getCoin() < 1) 
                {
                    allPlayers.removePlayer(index);    
                }
                
                if(player2.getCoin() >=20)
                {
                    allPlayers.addPlayer(player2.copy());
                    player2.setCoin(10);
                } else if (player2.getCoin() < 1) 
                {
                    allPlayers.removePlayer(index2);
                }
                // System.out.print("\nPLAYER ONE:\t" + player1.getName() + "\tCOINS:\t"+ player1.getCoin() + "\t|\tPLAYER TWO:\t" + player2.getName() + "\tCOINS:\t"+ player2.getCoin());
                machine.round(player1,player2);
            }
            
            for(int i=0; i<this.allPlayers.getSize() ; i++)
            {
                Person player = getPlayer(i);
                if(machine.endOfRound(player))
                {
                    allPlayers.removePlayer(i);
                    continue;
                }
                
            }
            System.err.printf("\nCHEATERS: %d\t|\tCOLLABORATIVES: %d\t|\tCOPYCAT: %d\t|\tGRUMPY: %d\t|\tTOLERANT: %d\n",Cheater.getCount(), Collaborative.getCount(), Copycat.getCount(), Grumpy.getCount(), Tolerant.getCount());
        }
        System.out.printf("\n\n\n\nTOTAL ROUNDS: %d",rounds);
    }
}
