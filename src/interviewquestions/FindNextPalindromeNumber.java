/*
 * Given a number, find the next smallest palindrome larger than the number. 
 * For example if the number is 125, next smallest palindrome is 131. 
 * - See more at: 
 * http://www.ardendertat.com/2012/01/09/programming-interview-questions/#sthash.2pMXnjIl.dpuf
 */
package interviewquestions;

/**
 *
 * @author Kyoo
 */
public class FindNextPalindromeNumber {
    public static void main(String[] args) {
        System.out.println(nextPalindromeNum(11));
    }

    private static int nextPalindromeNum(int num) {
        char[] sNum= String.valueOf(num).toCharArray();
        int pal=Integer.parseInt(getPal(sNum));
        if(pal<=num){
            if(sNum.length%2==0)
                sNum[sNum.length/2-1]++;
            else
                sNum[sNum.length/2]++;
            pal=Integer.parseInt(getPal(sNum));
        }
        return pal;
    }

    private static String getPal(char[] sNum) {
        StringBuilder nextP= new StringBuilder("");
        for (int i = 0; i < sNum.length/2; i++)
            nextP.append(sNum[i]);        
        StringBuilder inv= new StringBuilder(nextP.toString());
        inv.reverse();
        if(sNum.length%2==0)
            nextP.append(inv);
        else
            nextP.append(sNum[sNum.length/2]).append(inv);
        return nextP.toString();
    }
}
