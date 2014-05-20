/*
 * Convert an Integer to Binary Number
 */
package interviewquestions;

/**
 *
 * @author Kyoo
 */
public class IntegerToBinary {
    public static void main(String[] args) {
        System.out.println(toBinary(12134));
    }

    private static String toBinary(int n) {
        StringBuilder sb= new StringBuilder("");
        for (int i = 1; i <=32; i++){
            sb.append((n&Integer.MIN_VALUE)==0?0:1);
            n<<=1;
        }
        return sb.toString();
    }
}
