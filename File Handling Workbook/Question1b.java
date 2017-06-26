import java.io.*;
public class Question1b
{
    public static void main(String[]args) throws IOException 
    {
        FileReader myFile=new FileReader("U:\\Computing\\File handling\\Code.txt");
        BufferedReader br= new BufferedReader (myFile);
        String myText=br.readLine();
        do{
            System.out.println(myText);        
        }   while ((myText=br.readLine()) != null);
    }
}