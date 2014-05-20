/*
 * Assume you have a method isSubstring which checks if one word is a substring of 
 * another Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using 
 * only one call to isSubstring (i e , “waterbottle” is a rotation of “erbottlewat”) 
 */
package crackingcodeinterview.arraystrings;

/**
 *
 * @author Kyoo
 */
public class isSubstringRotation {
    public static void main(String[] args) {
        String st= "waterbottle";
        String rotate="erbottlewat";
        System.out.println(isSubstringRotate(st,rotate));
    }

    private static boolean isSubstringRotate(String st, String rotate) {
        return (rotate+rotate).contains(st);
    }
}
