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
        String allConcat;
        
        PrintWriter fout = null;
        try
        {
            fout = new PrintWriter(new File("output/composition.txt"));
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
    public static void checkWord(String[] dictionary, String[] concatenatedWords, String word, String subWord, PrintWriter fout)
    {
        String[] wordReturned = concatenatedWords;
        String foundWord = "";
        
        if(concatenatedWords[0] == null && subWord.length() < word.length())
        {
            if(Arrays.binarySearch(dictionary, subWord) >= 0)
            {
                concatenatedWords[0] = subWord;
                subWord = word.substring(subWord.length());
                //checkWord(dictionary, concatenatedWords, word, subWord, fullWord);
            }
            else
            {
                subWord = word.substring(0, subWord.length() + 1);   
                //checkWord(dictionary, concatenatedWords, word, subWord, fullWord);
            }
            checkWord(dictionary, concatenatedWords, word, subWord, fout);
        }
        else if(concatenatedWords[1] == null && subWord.length() < word.length())
        {
            if(Arrays.binarySearch(dictionary, subWord) >= 0 && subWord.length() == word.substring(subWord.length()).length())
            {
                concatenatedWords[1] = subWord;
                //subWord = word.substring(subWord.length());
                fout.println(word + ":" + concatenatedWords[0] + " " + concatenatedWords[1] + "\n");
            }
            else
            {
                subWord = word.substring(0, subWord.length() + 1); 
                //checkWord(dictionary, concatenatedWords, word, subWord, fullWord);
            }
            checkWord(dictionary, concatenatedWords, word, subWord, fout);
        }    
        //return allConcat;
    }
    public static void checkAll(String[] dictionary, PrintWriter fout)
    {
        String allConcat = "";
        for(int i = 0; i < dictionary.length; i++)
        {
            checkWord(dictionary, new String[2], dictionary[i], dictionary[i].substring(0,1), fout);   
        }
        //return allConcat;
    }
}
