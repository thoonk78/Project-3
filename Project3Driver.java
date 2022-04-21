import java.util.Scanner;
/**
 * Write a description of class Project3Driver here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Project3Driver
{
    public static void main(String[] args)
    {
        Scanner scnr = new Scanner(System.in);
        
        MyWord word1 = new MyWord("cat");
        MyWord word2 = new MyWord("dog");
        
        System.out.printf("%d\n", word1.compareTo(word2));
    }
}
