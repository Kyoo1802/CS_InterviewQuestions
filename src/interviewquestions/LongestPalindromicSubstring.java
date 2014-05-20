/*
 * Find The Longest Palindromic substring in a String
 */
package interviewquestions;

/**
 *
 * @author Kyoo
 */
//DP
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String word= "ssdaddaaddadss";
        System.out.println(longestPalSubs(word));        
    }

    private static String longestPalSubs(String word) {
        boolean[][] table= new boolean[word.length()][word.length()];
        int maxL=1;
        int idxMaxL=0;
        for (int i = 0; i < table.length; i++)
            table[i][i]=true;
        
        for (int i = 0; i < table.length-1; i++) {
            if(word.charAt(i)==word.charAt(i+1)){
                table[i][i+1]=true;
                maxL=2;
                idxMaxL=i;
            }
        }
        for (int length = 3; length <= table.length; length++) {
            for (int i = 0; i+length-1 < table.length; i++) {
                if(word.charAt(i)==word.charAt(i+length-1) && table[i+1][i+length-2]){
                    table[i][i+length-1]=true;
                    maxL=length;
                    idxMaxL=i;
                }
            }
        }
        
        return word.substring(idxMaxL, idxMaxL+maxL);
    }
}
