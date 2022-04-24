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
    public static void checkWord(String[] dictionary, String word, String subWord, PrintWriter fout)
    {
        //String secondPart;
        boolean secondFound = false;
        while(!secondFound && subWord.length() < word.length())
        {
            if(subWord.length() < word.length() && Arrays.binarySearch(dictionary, subWord) >= 0)
            {
                //String secondPart = word.substring(subWord.length());
                if(Arrays.binarySearch(dictionary, word.substring(subWord.length())) >= 0)
                {
                    secondFound = true;
                    fout.println(word + ":" + subWord + " " + word.substring(subWord.length()) + "\n");
                }
                else
                {
                    subWord = word.substring(0, subWord.length() + 1); 
                    //checkWord(dictionary, concatenatedWords, word, subWord, fout);
                }
            }
            else
            {
                subWord = word.substring(0, subWord.length() + 1); 
            }
        }
    }
    public static void checkAll(String[] dictionary, PrintWriter fout)
    {
        String allConcat = "";
        for(int i = 0; i < dictionary.length; i++)
        {
            checkWord(dictionary, dictionary[i], dictionary[i].substring(0,1), fout);   
        }
        //return allConcat;
    }
}
