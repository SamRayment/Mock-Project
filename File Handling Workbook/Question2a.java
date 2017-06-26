import java.util.Scanner;
import java.io.*;
public class Question2a{
    public static void main(String[]args) throws IOException{
        FileWriter myFile=new FileWriter("U:\\Computing\\File handling\\data.txt");
        BufferedWriter bw=new BufferedWriter(myFile);
        String [] [] myStudents=new String [5][3];
        myStudents[0][0]="Sophie";
        myStudents[0][1]="Stanfield";
        myStudents[0][2]="Class 5";
        
        myStudents[1][0]="James";
        myStudents[1][1]="Kitson";
        myStudents[1][2]="Class 1";
        
        myStudents[2][0]="Zoe";
        myStudents[2][1]="Gaskill";
        myStudents[2][2]="Class 1";
        
        myStudents[3][0]="Paul";
        myStudents[3][1]="Johns";
        myStudents[3][2]="Class 1";
        
        myStudents[4][0]="Freya";
        myStudents[4][1]="Moore";
        myStudents[4][2]="Class 5";
        
        for (int row=0; row<=4; row++){
            for(int column=0; column<=2; column++){
                bw.write(myStudents[row][column]+"\t");
            }
            bw.newLine();
        }
        myFile.close();
    }
}
