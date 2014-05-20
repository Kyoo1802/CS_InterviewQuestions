/*
 *  find the longest string (or strings) that is a substring (or are substrings) of two or more strings.
 */
package interviewquestions;

import java.util.Arrays;

/**
 *
 * @author Kyoo
 */
public class LongestCommonSubstring {
    public static void main(String[] args) {
        String str1= "aaabbb";
        String str2= "aabb";
        System.out.println(lcs(str1,str2));
    }

    private static int lcs(String str1, String str2) {
        int[][] dp= new int[str1.length()+1][str2.length()+1];
        int max=0;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if(i==0||j==0)
                    dp[i][j]=0;
                else if(str1.charAt(i-1)==str2.charAt(j-1))
                    dp[i][j]=dp[i-1][j-1]+1;
                max=Math.max(dp[i][j], max);
            }
        }
        String s=getString(dp,dp.length-1,dp[0].length-1,str1);
        System.out.println(s);
        return max;
    }

    private static String getString(int[][] dp,int i, int j,String s) {
        if(i<=0|| j<=0)
            return "";
        if(dp[i][j]>dp[i][j-1] && dp[i][j]>dp[i-1][j])
            return getString(dp, i-1, j-1, s)+s.charAt(i-1);
        else if(dp[i-1][j]>dp[i][j-1])
            return getString(dp, i-1, j, s);
        else
            return getString(dp, i, j-1, s);
    }
}
