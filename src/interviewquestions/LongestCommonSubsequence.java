/*
 * find the longest subsequence common to all sequences in a set of sequences 
 * (often just two).
 */
package interviewquestions;

/**
 *
 * @author Kyoo
 */
public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String st1= "AGCATC";
        String st2= "GAC";
        System.out.println(lcs(st1,st2));
    }

    private static int lcs(String st1, String st2) {
        int[][] dp=new int[st1.length()+1][st2.length()+1];
        for (int i=0; i<dp.length;i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if(i==0 || j==0)
                    dp[i][j]=0;
                else if(st1.charAt(i-1)==st2.charAt(j-1))
                    dp[i][j]=dp[i-1][j-1]+1;
                else
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}
