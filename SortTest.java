import java.util.Arrays;
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.FileNotFoundException;
/**
 * Write a description of class SortTest here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SortTest
{
    public static void main(String[] args)
    {
        String inputFile = "default.txt";
        String outputFile = "output/sorted.txt"; 
        
        if(args.length >= 1)
        {
            inputFile = args[0];   
        }
        else if(args.length < 1)
        {
            System.out.println("Must enter a file path for input");
            System.exit(0);
        }
        if(args.length == 2)
        {
            outputFile = args[1];
        }
        
        MyWord[] wordArray = new MyWord[1];
        Scanner fin = null;
        try
        {
            fin = new Scanner(new File(inputFile));
            int linesScanned = 0;
            
            while(fin.hasNextLine())
            {
                    if(wordArray.length < linesScanned + 1)
                {
                    MyWord[] temp = new MyWord[linesScanned + 1];
                    for(int i  = 0; i < wordArray.length; i++)
                    {
                        temp[i] = wordArray[i];
                    }
                    wordArray = temp;
                }
                String line = fin.next();
                wordArray[linesScanned] = new MyWord(line);
                linesScanned++;
            }
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Couldn't find that file");
        }
        finally
        {
            if(fin != null)
            {
                fin.close();   
            }
        }
        Arrays.sort(wordArray);
        
        PrintWriter fout = null;
        try
        {
            fout = new PrintWriter(outputFile);   
            for(int i = 0; i < wordArray.length; i++)
            {
                fout.println(wordArray[i]);   
            }
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Couldn't find that file.");   
        }
        finally
        {
            if(fout != null)
            {
                fout.close();   
            }
        }
    }
}
