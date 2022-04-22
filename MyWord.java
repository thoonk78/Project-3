
/**
 * Write a description of class MyWord here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MyWord implements Comparable<MyWord>
{
    String word;
    public MyWord(String word)
    {
        this.word = word;
    }
    public int compareTo(MyWord otherWord)
    {
        boolean equal = true;
        int compareVal = 0;
        int i = 0;
        while(i < this.word.length() && i < otherWord.word.length() && equal == true)
        {
            if(this.word.toLowerCase().charAt(i) > otherWord.word.toLowerCase().charAt(i))
            {
                compareVal = -1;
                equal = false;
            }
            else if(this.word.toLowerCase().charAt(i) < otherWord.word.toLowerCase().charAt(i))
            {
                compareVal = 1;   
                equal = false;
            }
            else if(this.word.length() > otherWord.word.length())
            {
                 compareVal = -1;
                 equal = false;
            }
            else if(this.word.length() < otherWord.word.length())
            {
                 compareVal = 1;
                 equal = false;
            }
            else
            {
                i++;   
            }
        }
        return compareVal;
    }
    public String toString()
    {
        return this.word;   
    }
}
