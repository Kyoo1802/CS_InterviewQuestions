/*
 * Implement an algorithm to determine if a string has all unique characters What if you 
 * can not use additional data structures?
 */
package crackingcodeinterview.arraystrings;

/**
 *
 * @author Kyoo
 */
public class UniqueCharacters {
    public static void main(String[] args) {
        String str="asknd";
        System.out.println(hasUniqueChars(str));
    }

    private static boolean hasUniqueChars(String str) {
        int uniqueChars=0;
        for (int i = 0; i < str.length(); i++) {
            int posChar=str.charAt(i)-'a';
            if( (uniqueChars&1<<posChar)!=0)
                return false;
            uniqueChars|=1<<posChar;
        }
        return true;
    }
}
