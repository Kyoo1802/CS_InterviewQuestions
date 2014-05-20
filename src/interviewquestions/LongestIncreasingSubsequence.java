/*
 * find a subsequence of a given sequence in which the subsequence's elements 
 * are in sorted order, lowest to highest, and in which the subsequence is as 
 * long as possible
 */
package interviewquestions;

import java.util.Arrays;

/**
 *
 * @author Kyoo
 */
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] sequence={0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
        System.out.println(Arrays.toString(longestIncSubs(sequence)));
        System.out.println(Arrays.toString(longestIncSubsNLN(sequence)));
    }
    //DP
    private static int[] longestIncSubs(int[] sequence) {
        int[] subs= new int[sequence.length];
        Arrays.fill(subs, 1);
        for (int i = 1; i < sequence.length; i++) 
            for (int j = 0; j < i; j++) 
                if(sequence[i]>=sequence[j])
                    subs[i]=Math.max(subs[i], subs[j]+1);
        return subs;
    }

    private static int[] longestIncSubsNLN(int[] sequence) {
        int[] c= new int[sequence.length+1];
        int[] dp= new int[sequence.length];
        c[1]=sequence[0];
        dp[0]=1;
        int last=1;
        for (int i = 1; i < sequence.length; i++) {
            if(c[last]<sequence[i]){
                c[++last]=sequence[i];
                dp[i]=last;
            }
            else{
                int k=Arrays.binarySearch(c, 0, last, sequence[i]);
                k=k<0?-(k+1):k;
                c[k]=sequence[i];
                dp[i]=k;
            }
        }
        return dp;
    }
}
