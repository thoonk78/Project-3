import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
/**
 * Program takes a .txt file as a dictionary of words and checks if any of those words can be broken into three
 * or more words. 
 *
 * @author Samuel Ayoade, Keith Thoong
 * @version 4/24/2022
 */
public class CompositionTwo
{
    /**
     * Main method for initiating the check
     * 
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
    /**
     * Fills an array with the words from a .txt file
     * 
     * @param dictionary the array to be filled
     * @return the array filled with words from the .txt file
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
     * Checks to see if a word can be broken into 3 or more words
     * 
     * @param dictionary the array to reference all words
     * @param concatenatedWords a String of subwords that the word can be broken into
     * @param word the word to check
     * @param subWord a string of parts of the full word to be checked as a valid word
     * @param fullWord the full word being cheked
     * @param wordCount the number of subwords that have been found
     * @param fout the PrintWriter to write to the file.
     */
    public static void checkWord(String[] dictionary, String concatenatedWords, String word, String subWord, String fullWord, int wordCount, PrintWriter fout)
    {
        if(subWord.length() < word.length())
        {
            if(Arrays.binarySearch(dictionary, subWord) >= 0)
            {
                concatenatedWords += subWord + " ";
                word = word.substring(subWord.length());
                subWord = word.substring(0,1);
                wordCount ++;
            }
            else
            {
                subWord = word.substring(0, subWord.length() + 1);   
            }
            checkWord(dictionary, concatenatedWords, word, subWord, fullWord, wordCount, fout);
        }
        else if(wordCount >= 2 && Arrays.binarySearch(dictionary, subWord) >= 0)
        {
            concatenatedWords += subWord;
            fout.println(fullWord + ":" + concatenatedWords + "\n");
        }    
    }
    /**
     * Checks all the words in the .txt file to see if it can be broken up
     * 
     * @param dictionary the array of words to be checked
     * @param fout the PrintWriter to write to the file
     */
    public static void checkAll(String[] dictionary, PrintWriter fout)
    {
        String allConcat = "";
        for(int i = 0; i < dictionary.length; i++)
        {
            checkWord(dictionary, "", dictionary[i], dictionary[i].substring(0,1), dictionary[i], 0, fout);   
        }
    }
}
