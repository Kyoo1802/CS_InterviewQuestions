/*
 * There is an array of non-negative integers. A second array is formed by 
 * shuffling the elements of the first array and deleting a random element. 
 * Given these two arrays, find which element is missing in the second array. 
 * - See more at: 
 * http://www.ardendertat.com/2012/01/09/programming-interview-questions/#sthash.bk8CTgTL.dpuf
 */
package interviewquestions;

/**
 *
 * @author Kyoo
 */
public class FindMissingElement {
    public static void main(String[] args) {
        int[] arr1={4,1,0,2,9,6,8,7,5,3};
        int[] arr2={6,4,7,2,1,0,8,3,9};
        System.out.println(solve(arr1,arr2));
    }

    private static int solve(int[] arr1, int[] arr2) {
        int sol=0;
        for (int i = 0; i < arr1.length; i++) {
            sol^=arr1[i];
        }
        for (int i = 0; i < arr2.length; i++) {
            sol^=arr2[i];
        }
        return sol;
    }
    
}
