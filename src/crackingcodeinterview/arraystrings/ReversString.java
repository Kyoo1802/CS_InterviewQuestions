/*
 * Write code to reverse a C-Style String (C-String means that “abcd” is represented as 
 * five characters, including the null character )
 */
package crackingcodeinterview.arraystrings;

/**
 *
 * @author Kyoo
 */
public class ReversString {
    public static void main(String[] args) {
        String str="asknd";
        System.out.println(reverseString(str));
    }

    private static String reverseString(String str) {
        StringBuilder sB= new StringBuilder("");
        for (int i = str.length()-1; i >=0; i--)
            sB.append(str.charAt(i));
        return sB.toString();
    }
}
