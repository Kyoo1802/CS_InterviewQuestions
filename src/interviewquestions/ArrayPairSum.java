/*
 * Given an integer array, output all pairs that sum up to a specific value k. 
 * - See more at: 
 * http://www.ardendertat.com/2012/01/09/programming-interview-questions/#sthash.bk8CTgTL.dpuf
 */
package interviewquestions;

import java.util.Arrays;
import java.util.HashMap;

/**
 *
 * @author Kyoo
 */

public class ArrayPairSum {
    public static void main(String[] args) {
        int k=10;
        int[] arr= new int[]{2,3,1,23,23,12,4,45,3,7,86,53,12,3,4,34,1,23};
        System.out.println(solve2(arr,k));
    }

    private static int solve(int[] arr, int k) {
        Arrays.sort(arr);
        int cont=0;
        for (int i = 0; i <arr.length && arr[i]<k; i++) {
            int r=0;
            while( (r=Arrays.binarySearch(arr,r,arr.length, k-arr[i]))>=0 ){                
                if(r<i)
                    cont++;
                r++;
            }
        }
        return cont;
    }
    private static int solve2(int[] arr, int k) {
        int cont=0;
        HashMap<Integer,Integer> set= new HashMap<>();
        for (int i = 0; i <arr.length; i++) {
            int v=k-arr[i];
            if(set.containsKey(v)){
                cont+=set.get(v);
            }
            if(set.containsKey(arr[i]))
                set.put(arr[i],set.get(arr[i])+1);
            else
                set.put(arr[i],1);
        }
        return cont;
    }
}