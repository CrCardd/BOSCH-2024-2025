using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using desafio;


void banana (List<Cube> cubes, int index, StreamWriter writer)
{
    for(int x = 0; x < 24; x++)
    {
        // FACE  ROTACAO

        cubes[index].rotate(x / 4, x % 4);
        
        bool can = true;
        for(int cmp = index-1; cmp >= 0; cmp--)
            if(
                cubes[index].front == cubes[cmp].front ||
                cubes[index].back == cubes[cmp].back ||
                cubes[index].bottom == cubes[cmp].bottom ||
                cubes[index].top == cubes[cmp].top
            )
            {
                can = false;
                break;
            }

        if(!can)
            continue;
       
        Count.count++;

        if(index < cubes.Count-1)
            banana(cubes, index + 1, writer);
        else
            // if(
            //     cubes[0].top != cubes[1].top && cubes[2].top != cubes[3].top && cubes[0].top != cubes[3].top && cubes[1].top != cubes[2].top && cubes[0].top != cubes[2].top && cubes[1].top != cubes[3].top
            //     &&
            //     cubes[0].front != cubes[1].front && cubes[2].front != cubes[3].front && cubes[0].front != cubes[3].front && cubes[1].front != cubes[2].front && cubes[0].front != cubes[2].front && cubes[1].front != cubes[3].front
            //     &&
            //     cubes[0].bottom != cubes[1].bottom && cubes[2].bottom != cubes[3].bottom && cubes[0].bottom != cubes[3].bottom && cubes[1].bottom != cubes[2].bottom && cubes[0].bottom != cubes[2].bottom && cubes[1].bottom != cubes[3].bottom
            //     &&
            //     cubes[0].back != cubes[1].back && cubes[2].back != cubes[3].back && cubes[0].back != cubes[3].back && cubes[1].back != cubes[2].back && cubes[0].back != cubes[2].back && cubes[1].back != cubes[3].back
            // )
                // writer.WriteLine(cubes[0].top + "," + cubes[1].top + "," +  cubes[2].top + "," + cubes[3].top);
            writer.WriteLine("ganhemo FC");

    }
}






StreamReader reader = new StreamReader("Cubes.txt");

List<Cube> cubes = new();

string line = reader.ReadLine();
while(line != null)
{
    
    if(line == "")
        break;

    List<Colors> colors = new();
    foreach(string color in line.Split(","))
        switch(color)
        {
            case "RED":
                colors.Add(Colors.RED);
                break;
            case "BLUE":
                colors.Add(Colors.BLUE);
                break;
            case "GREEN":
                colors.Add(Colors.GREEN);
                break;
            case "YELLOW":
                colors.Add(Colors.YELLOW);
                break;
            default:
                continue;
        }
    cubes.Add(new(colors));
    cubes.Last().setOriginal(colors);
    line = reader.ReadLine();
}
StreamWriter writer = new StreamWriter("Solutions.txt");

banana(cubes, 0, writer);
Console.WriteLine(Count.count);

writer.Close();

// void abacate(int x, int totalPos)
// {

// }

// abacate(0, 331_776);



























// int poss = 0;
// for(int i = 0; i < 12; i++)
// {
//     int i_ = i / 4;
//     switch(i_)
//     {
//         case 0:
//             cubes[0].rotateX();
//             break;
//         case 1:
//             cubes[0].rotateY();
//             break;
//         case 2:
//             cubes[0].rotateZ();
//             break;
//     }
//     // if(cubes[0].top != cubes[1].top || cubes[0].front != cubes[1].front)
//     //     continue;
//     for(int j = 0; j < 12; j++)
//     {
//         int j_ = i / 4;
//         switch(j_)
//         {
//             case 0:
//                 cubes[1].rotateX();
//                 break;
//             case 1:
//                 cubes[1].rotateY();
//                 break;
//             case 2:
//                 cubes[1].rotateZ();
//                 break;
//         }
//         // if(cubes[0].top != cubes[1].top || cubes[0].front != cubes[1].front)
//         //     continue;
//         for(int k = 0; k < 12; k++)
//         {
//             int k_ = i / 4;
//             switch(k_)
//             {
//                 case 0:
//                     cubes[2].rotateX();
//                     break;
//                 case 1:
//                     cubes[2].rotateY();
//                     break;
//                 case 2:
//                     cubes[2].rotateZ();
//                     break;
//             }
//             // if(cubes[1].top != cubes[2].top || cubes[1].front != cubes[2].front)
//             //     continue;
//             for(int l = 0; l < 12; l++)
//             {
//                 int l_ = i / 4;
//                 switch(l_)
//                 {
//                     case 0:
//                         cubes[3].rotateX();
//                         break;
//                     case 1:
//                         cubes[3].rotateY();
//                         break;
//                     case 2:
//                         cubes[3].rotateZ();
//                         break;
//                 }

//                 if( 
//                     cubes[0].top != cubes[1].top && cubes[2].top != cubes[3].top && cubes[0].top != cubes[3].top && cubes[1].top != cubes[2].top && cubes[0].top != cubes[2].top && cubes[1].top != cubes[3].top
//                     // &&
//                     // cubes[0].front != cubes[1].front && cubes[2].front != cubes[3].front && cubes[0].front != cubes[3].front && cubes[1].front != cubes[2].front && cubes[0].front != cubes[2].front && cubes[1].front != cubes[3].front
//                     // &&
//                     // cubes[0].bottom != cubes[1].bottom && cubes[2].bottom != cubes[3].bottom && cubes[0].bottom != cubes[3].bottom && cubes[1].bottom != cubes[2].bottom && cubes[0].bottom != cubes[2].bottom && cubes[1].bottom != cubes[3].bottom
//                     // &&
//                     // cubes[0].back != cubes[1].back && cubes[2].back != cubes[3].back && cubes[0].back != cubes[3].back && cubes[1].back != cubes[2].back && cubes[0].back != cubes[2].back && cubes[1].back != cubes[3].back
//                 )
//                 {
//                     poss++;
//                     writer.WriteLine(cubes[0].top + "," + cubes[1].top + "," +  cubes[2].top + "," + cubes[3].top);
//                 }
//             }
//         }
//     }
// }
// writer.Close();
// Console.WriteLine(poss);