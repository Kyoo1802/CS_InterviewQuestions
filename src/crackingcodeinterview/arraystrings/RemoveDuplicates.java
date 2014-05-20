/*
 * Design an algorithm and write code to remove the duplicate characters in a char array 
 * without using any additional buffer NOTE: One or two additional variables are fine 
 * An extra copy of the array is not 
 */
package crackingcodeinterview.arraystrings;

/**
 *
 * @author Kyoo
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        char[] str="assknd".toCharArray();
        System.out.println(removeDuplicates(str));
    }

    private static String removeDuplicates(char[] arStr) {
        if(arStr==null)
            return null;
        if(arStr.length==1) 
            return String.valueOf(arStr);
        int last=1;
        for (int j = 1; j < arStr.length; j++) {
            int i=0;
            for (i = 0; i <last; i++)
                if(arStr[i]==arStr[j])
                    break;
            if(i==last){
                arStr[last]=arStr[j];
                last++;
            }
        }
        return String.valueOf(arStr).substring(0,last);
    }
}