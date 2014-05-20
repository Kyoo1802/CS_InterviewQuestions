/*
 * Write a method to decide if two strings are anagrams or not
 */
package crackingcodeinterview.arraystrings;

/**
 *
 * @author Kyoo
 */
public class TwoStringAnagram {
    public static void main(String[] args) {
        String str1="asknd";
        String str2="anask";
        System.out.println(areAnagrams(str1,str2));
    }

    private static boolean areAnagrams(String str1, String str2) {
        if(str1.length()!=str2.length())
            return false;
        int[] charUseds= new int[256];
        for (int i = 0; i < str1.length(); i++)
            charUseds[str1.charAt(i)]++;
        int charCompleted=0;
        for (int i = 0; i < str2.length(); i++) {
            if(--charUseds[str2.charAt(i)]<0)
                return false;
            else if(charUseds[str2.charAt(i)]==0)
                charCompleted++;
        }
        return charCompleted==str2.length();
    }
}
