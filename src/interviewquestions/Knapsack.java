/*
 * Given a set of items, each with a mass and a value, determine the number of 
 * each item to include in a collection so that the total weight is less than or 
 * equal to a given limit and the total value is as large as possible
 */
package interviewquestions;

import java.util.Arrays;

/**
 *
 * @author Kyoo
 */
public class Knapsack {
    public static void main(String[] args) {
        int[] w={1,7,4,3};
        int[] v={3,1,2,5};
        int W=7;
        int[][] dp= knapsack(w,v,W);
        for (int[] arr : dp)
            System.out.println(Arrays.toString(arr));
        
    }

    private static int[][] knapsack(int[] w, int[] v, int W) {
        int[][] dp= new int[v.length][W+1];
        
        for (int i = 0; i <v.length; i++) {
            for (int idxW = 0; idxW <=W; idxW++) {
                if(i==0)
                    dp[i][idxW]=idxW<=w[i]?0:v[i];
                else if(w[i]<=idxW)
                    dp[i][idxW]=Math.max(dp[i-1][idxW], dp[i-1][idxW-w[i]]+v[i]);
                else
                    dp[i][idxW]=dp[i-1][idxW];
            }
        }
        return dp;
    }
}
