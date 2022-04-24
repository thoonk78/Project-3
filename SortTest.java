import java.util.Arrays;
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.FileNotFoundException;
/**
 * This class has a main method that is expected to take one or two command-line arguments. The first argument must be given, and it should be a path to a file for input.
 * Reads in all words in the file and then sorts the array using the following method: Arrays.sort(...). Once your words are sorted, output them to the correct output file, 
 * separating each word by a newline.
 *
 * @author Samuel Ayoade & Keith Thoong
 * @version April 24th, 2022
 */
public class SortTest
{
    /**
     * Method main: Take's one or two command-line arguments and reads in all words in the file and then sorts the array.
     */
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
