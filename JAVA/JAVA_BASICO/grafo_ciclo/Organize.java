import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;

public class Organize {

    public void organize()
    {
        Map map = new Map();
        String[] lines = null,data;
        String arq;
        Integer index;
        ArrayList<Integer> arrayInt;
        try {
            File file = new File("desafio1.txt");
            arq = new String(Files.readAllBytes(file.toPath()));
            arq = arq.replace(" ","");
            lines = arq.split("\n");
        } catch (Exception e){}
        
        for( String value : lines)
        {
            
            data = value.split(">");
            
            index = Integer.parseInt(data[0]);
            
            data = data[1].split(",");
            
            arrayInt = new ArrayList<>(); 
            
            for(String i : data)
            {
                try{
                    arrayInt.add(Integer.parseInt(i));
                }
                catch(Exception e){}
            }



            map.addWay(index, arrayInt);
        }

    }
    
}
