import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
/**
 * Write a description of class CompositionTwo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CompositionTwo
{
    public static void main(String[] args)
    {
        String[] dictionary = new String[1];
        int numWords = 1;
        dictionary = fillArray(dictionary);
        String allConcat;
        
        PrintWriter fout = null;
        try
        {
            fout = new PrintWriter(new File("output/moreCompositions.txt"));
            checkAll(dictionary, fout);
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Couldn't find that file");
        }
        finally
        {
            if(fout != null)
            {
                fout.close();
            }
        }
        
    }
    public static String[] fillArray(String[] dictionary)
    {
        Scanner fin = null;
        try
        {
            fin = new Scanner(new File("dictionary.txt"));
            int linesScanned = 0;
            //String[] temp = new String[1];
            String temp = "";
            
            while(fin.hasNextLine())
            {
                temp += fin.nextLine() + " ";
            }
            dictionary = temp.split(" ");
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
    public static void checkWord(String[] dictionary, String concatenatedWords, String word, String subWord, String fullWord, int wordCount, PrintWriter fout)
    {
        //String[] wordReturned = concatenatedWords;
        //String foundWord = "";
        
        if(subWord.length() < word.length())
        {
            if(Arrays.binarySearch(dictionary, subWord) >= 0)
            {
                concatenatedWords += subWord + " ";
                word = word.substring(subWord.length());
                subWord = word.substring(0,1);
                wordCount ++;
                //checkWord(dictionary, concatenatedWords, word, subWord, fullWord);
            }
            else
            {
                subWord = word.substring(0, subWord.length() + 1);   
                //checkWord(dictionary, concatenatedWords, word, subWord, fullWord);
            }
            checkWord(dictionary, concatenatedWords, word, subWord, fullWord, wordCount, fout);
        }
        else if(wordCount >= 2 && Arrays.binarySearch(dictionary, subWord) >= 0)
        {
            concatenatedWords += subWord;
            fout.println(fullWord + ":" + concatenatedWords + "\n");
            //checkWord(dictionary, concatenatedWords, word, subWord, fout);
        }    
        //return allConcat;
    }
    public static void checkAll(String[] dictionary, PrintWriter fout)
    {
        String allConcat = "";
        for(int i = 0; i < dictionary.length; i++)
        {
            checkWord(dictionary, "", dictionary[i], dictionary[i].substring(0,1), dictionary[i], 0, fout);   
        }
        //return allConcat;
    }
}
