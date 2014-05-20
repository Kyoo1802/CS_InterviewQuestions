/*
 * Find the first non-repeated (unique) character in a given string. 
 * - See more at: 
 * http://www.ardendertat.com/2012/01/09/programming-interview-questions/#sthash.bk8CTgTL.dpuf
 */
package interviewquestions;

/**
 *
 * @author Kyoo
 */
public class FirstNonRepeatedCharacter {
    public static void main(String[] args) {
        String txt="aksjdnvfjnj3naslsa";
        System.out.println(firstUniqueChar(txt));
    }

    private static char firstUniqueChar(String txt) {
        int[] difCars= new int[256];
        for (int i = 0; i < txt.length(); i++)
            difCars[txt.charAt(i)]++;
        for (int i = 0; i < txt.length(); i++) {
            if(difCars[txt.charAt(i)]==1)
                return txt.charAt(i);
        }
        return ' ';
    }
}
