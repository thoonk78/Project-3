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
        
        checkAll(dictionary);
        
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
                if(fin.hasNextLine())
                {
                    for(int i = 0; i < dictionary.length; i++)
                    {
                        temp[i] = dictionary[i];
                    }
                    dictionary = temp;
                }
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
    public static String checkWord(String[] dictionary, String concatenatedWords, String word, String subWord, String fullWord)
    {
        String wordReturned = concatenatedWords;
        

        if(subWord.compareTo(word) != 0)
        {
            int foundAt = Arrays.binarySearch(dictionary, subWord);
            
            if(foundAt >= 0)
            {
                concatenatedWords += subWord + " ";
                word = word.substring(subWord.length());
                subWord = word.substring(0, 1);
                //checkWord(dictionary, concatenatedWords, word, subWord);
            }
            else
            {
                subWord = word.substring(0, subWord.length() + 1);   
                //checkWord(dictionary, concatenatedWords, word, subWord);
            }
            concatenatedWords = checkWord(dictionary, concatenatedWords, word, subWord, fullWord);
            
        }
        else
        {
            if(Arrays.binarySearch(dictionary, subWord) >= 0 && subWord.compareTo(fullWord) != 0)
            {
                concatenatedWords += subWord;   
            }
            wordReturned = concatenatedWords;   
        }
        return concatenatedWords;
    }
    public static void checkAll(String[] dictionary)
    {
        for(int i = 0; i < dictionary.length; i++)
        {
            System.out.println(dictionary[i] + ":" + checkWord(dictionary, "", dictionary[i], dictionary[i].substring(0,1), dictionary[i]));   
        }
    }
}
