import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
/**
 * Write a description of class Composition here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Composition
{
    public static void main(String[] args)
    {
        String[] dictionary = new String[1];
        int numWords = 1;
        dictionary = fillArray(dictionary);
        
    }
    public static String[] fillArray(String[] dictionary)
    {
        Scanner fin = null;
        try
        {
            fin = new Scanner(new File("dictionary.txt"));
            int linesScanned = 0;
            String[] temp = new String[1];
            
            while(fin.hasNextLine())
            {
                dictionary[linesScanned] = fin.nextLine();   
                linesScanned++;
                temp = new String[linesScanned + 1];
                
                for(int i = 0; i < dictionary.length; i++)
                {
                    temp[i] = dictionary[i];
                }
                dictionary = temp;
            }
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Couldn't find that file.");   
        }
        finally
        {
            if(fin != null)
            {
                fin.close();   
            }
        }
        Arrays.sort(dictionary);
        return dictionary;
    }
    public String checkWord(String[] dictionary, String concatenatedWords, String word, String subWord,int index)
    {
        //String[] wordsReturned;
        if(index == word.length())
        {
            return concatenatedWords;
        }
        else
        {
            int foundAt = Arrays.binarySearch(dictionary, word);
            
            if(foundAt > 0)
            {
                concatenatedWords += " " + dictionary[foundAt];
                index = 
            }
        }
    }
}
