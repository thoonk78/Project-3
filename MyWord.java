
/**
 * This class stores a String and implements the Comparable interface.
 *
 * @author Samuel Ayoade & Keith Thoong
 * @version April 24th, 2022
 */
public class MyWord implements Comparable<MyWord>
{
    String word;
    /**
     * MyWord Constructor: sets default word
     *
     * @param word: word passed in.
     */
    public MyWord(String word)
    {
        this.word = word;
    }
    
    /**
     * Method compareTo: overrides comparable overide class.
     *
     * @param otherWord: the word being compared
     * @return returns integer value after comparison
     */
    @Override
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
    
    
    /**
     * Method toString: returns string format of word 
     *
     * @return a string
     */
    @Override
    public String toString()
    {
        return this.word;   
    }
}
