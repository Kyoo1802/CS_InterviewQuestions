/*
 * Given an integer array, one element occurs even number of times and all 
 * others have odd occurrences. Find the element with even occurrences. 
 * - See more at: 
 * http://www.ardendertat.com/2012/01/09/programming-interview-questions/#sthash.bk8CTgTL.dpuf
 */
package interviewquestions;

import java.util.HashSet;

/**
 *
 * @author Kyoo
 */
public class FindEvenOcurringElement {
    public static void main(String[] args) {
        int[] arr= {1,2,1,1,2,3,3,4,4,3,2,2,3,4,3};
        System.out.println(findEvenOccurredElement(arr));
    }

    private static int findEvenOccurredElement(int[] arr) {
        HashSet<Integer> setArr= new HashSet<>();
        int r=0;
        for (Integer v : arr){
            r^=v;
            setArr.add(v);
        }
        for (Integer v : setArr)
            r^=v;
        return r;
    }
}
