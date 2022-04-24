
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
        String myWord = this.word;
        String comparedWord = otherWord.word;
        int compareVal = 0;
        int i = 0;
        
        if(this.word.charAt(0) > 64 && this.word.charAt(0) < 91)
        {
            myWord = (char)((int) this.word.charAt(0) + 32) + this.word.substring(1);
        }
        if(otherWord.word.charAt(0) > 64 && otherWord.word.charAt(0) < 91)
        {
            comparedWord = (char)((int) otherWord.word.charAt(0) + 32) + otherWord.word.substring(1);
        }
        
        while(i < myWord.length() && i < comparedWord.length() && equal == true)
        {
            if(myWord.charAt(i) > comparedWord.charAt(i))
            {
                compareVal = -1;
                equal = false;
            }
            else if(myWord.charAt(i) < comparedWord.charAt(i))
            {
                compareVal = 1;   
                equal = false;
            }
            else if(myWord.length() > comparedWord.length())
            {
                 compareVal = -1;
                 equal = false;
            }
            else if(myWord.length() < comparedWord.length())
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
