import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
/**
 * This class has a main method that is expected to take three command-line arguments: an input file location, a search term or phrase, and “true” or “false” 
 * to indicate whether per-line occurrences should be determined and output. Looks for how many times word appears in phrase.
 *
 * @author Samuel Ayoade & Keith Thoong
 * @version April 24th, 2022
 */
public class Search
{
    /**
     * Method main: Takes three command-line arguments: an input file location, a search term or phrase, and “true” or “false” 
     * to indicate whether per-line occurrences should be determined and output.
     *
     * @param args A parameter
     */
    public static void main(String[] args)
    {
        String inFile = "";
        String phrase = "";
        String perLineChoice = "";
        boolean perLine = false;
        if(args.length != 3)
        {
            System.out.println("Must include arguments for input file location, phrase to search for, and a boolean for including perLineOccurrences");   
            System.exit(0);
        }
        else
        {
            inFile = args[0];
            phrase = args[1];
            perLineChoice = args[2];

            if(perLineChoice.toLowerCase() == "true")
            {
                perLine = true;
            }
            else if(perLineChoice.toLowerCase() == "false")
            {
                perLine = false;
            }
            else
            {
                System.out.println("must enter true or false for per line occurrences");   
                System.exit(0);
            }
        }

        Scanner fin = null;
        PrintWriter fout = null;

        try
        {
            fin = new Scanner(new File(inFile));    
            int lineRead = 0;
            String line;
            try
            {
                fout = new PrintWriter("output/" + phrase + "_ocurrences.txt");   

                while(fin.hasNextLine())
                {
                    line = fin.nextLine();
                    Scanner lineReader = new Scanner(line);
                    int occurrences = 0;
                    boolean foundPhrase = false;
                    while(lineReader.hasNext())
                    {
                        String word = lineReader.next();
                        if(phrase.toLowerCase().compareTo(word.toLowerCase()) == 0)
                        {
                            foundPhrase = true;
                            occurrences++;   
                        }
                    }
                    if(foundPhrase == true)
                    {
                        if(perLine == true)
                        {
                            fout.printf("Line    %d - %d\n", lineRead + 1, occurrences);
                        }
                        else
                        {
                            fout.printf("Line    %d\n", lineRead + 1);
                        }
                    }
                    lineRead++;
                }
            }
            catch(FileNotFoundException e)
            {
                System.out.println("Couldnt find that file.");   
            }
            finally
            {
                if(fout != null)
                {
                    fout.close();   
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
    }
}
