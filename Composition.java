import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
/**
 * Checks to see if a word can be broken into two words and outputs to a file if true
 *
 * @author Samuel Ayoade, Keith Thoong
 * @version 4/24/2022
 */
public class Composition
{
    /**
     * Main method to call methods to check the word
     */
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
    /**
     * Fills an array with words from a .txt file
     * 
     * @param dictionary the array to bee filled with words
     * @return the array filled with words
     */
    public static String[] fillArray(String[] dictionary)
    {
        Scanner fin = null;
        try
        {
            fin = new Scanner(new File("dictionary.txt"));
            int linesScanned = 0;
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
    /**
     * Checks to see if a word can be broken into two words.
     * 
     * @param dictionary the array with words to be checked
     * @param word the word being checked
     * @param subword the subword of the word being checked
     * @param fou the PrinteWriter used to write to the output file
     */
    public static void checkWord(String[] dictionary, String word, String subWord, PrintWriter fout)
    {
        //String secondPart;
        boolean secondFound = false;
        while(!secondFound && subWord.length() < word.length())
        {
            if(subWord.length() < word.length() && Arrays.binarySearch(dictionary, subWord) >= 0)
            {
                if(Arrays.binarySearch(dictionary, word.substring(subWord.length())) >= 0)
                {
                    secondFound = true;
                    fout.println(word + ":" + subWord + " " + word.substring(subWord.length()) + "\n");
                }
                else
                {
                    subWord = word.substring(0, subWord.length() + 1);                 }
            }
            else
            {
                subWord = word.substring(0, subWord.length() + 1); 
            }
        }
    }
    /**
     * Calls the checkWord method on all words in the array
     * 
     * @param dictionary the array of words to check
     * @param fout the PrintWriter to write the the output file
     */
    public static void checkAll(String[] dictionary, PrintWriter fout)
    {
        String allConcat = "";
        for(int i = 0; i < dictionary.length; i++)
        {
            checkWord(dictionary, dictionary[i], dictionary[i].substring(0,1), fout);   
        }
    }
}
