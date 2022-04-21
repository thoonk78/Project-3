
/**
 * Write a description of class Search here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Search
{
    public static void main(String[] args)
    {
        String inFile;
        String phrase;
        boolean perLineOccurrences;
        
        if(args.length != 3)
        {
            System.out.println("Must include arguments for input file location, phrase to search for, and a boolean for including perLineOccurrences");   
            System.exit(0);
        }
        else
        {
            inFile = args[0];
            phrase = args[1];
        }
    }
}
