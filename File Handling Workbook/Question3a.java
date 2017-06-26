import java.io.*;
import java.util.Scanner;

public class Question3a
{
    public static void main(String[]args) throws IOException{
        FileReader myFile=new FileReader("U:\\Computing\\Java\\File Handling Workbook\\File handling workbook textfiles\\List of foods.txt");
        BufferedReader br=new BufferedReader(myFile);
        String [][] products=new String [5][5];
        int row=0;
        int column=0;
        
        for (row=0; row<=4; row++)
            {
            String food=br.readLine();
            products[row][column]=food.substring(0,5);
            System.out.println(products[row][column]);
            for(column=0;column<=0;column++){
                products[row][column]=food.substring(5);
                System.out.println(products[row][column]);
            }
        }
        myFile.close();
    }
}