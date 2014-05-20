/*
 * Given an array of integers (positive and negative) find the largest continuous sum.
 * - See more at: 
 * http://www.ardendertat.com/2012/01/09/programming-interview-questions/#sthash.bk8CTgTL.dpuf
 */
package interviewquestions;

/**
 *
 * @author Kyoo
 */
public class LargestContinuosSum {
    public static void main(String[] args) {
        int[] arr= new int[]{2,3,1,-23,23,-12,-4,-45,3,7,86,-53,12,-3,4,34,1,23};
        System.out.println(solve(arr));
    }

    private static int solve(int[] arr) {
        int sum=0, maxSum=0;
        for (int i = 0; i < arr.length; i++) {
            sum=Math.max(arr[i]+sum, 0);
            maxSum=Math.max(sum, maxSum);
        }
        return maxSum;
    }
}
