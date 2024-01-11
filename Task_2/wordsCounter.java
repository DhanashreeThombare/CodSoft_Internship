import java.io.BufferedReader;  
import java.io.FileReader;  
   
public class wordsCounter   
{  
    public static void main(String[] args) throws Exception 
    {  	
        String data;  
        
        int cnt = 0;  
          
        FileReader f=new FileReader("./data.txt");  
        
        BufferedReader br=new BufferedReader(f);  
              
        while((data=br.readLine()) != null) 
        {  
            String words[]=data.split(" ");  
            cnt=cnt+words.length;  
        }  
          
        System.out.println("Number of words present in given file are: " +cnt);  
        br.close();  
    }  
}  