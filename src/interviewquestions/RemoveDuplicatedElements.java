/*
 * Remove duplicate characters in a given string keeping only the first 
 * occurrences. For example, if the input is ‘tree traversal’ the output will be 
 * ‘tre avsl’. - See more at: 
 * http://www.ardendertat.com/2012/01/09/programming-interview-questions/#sthash.y7PGz0fH.dpuf
 */
package interviewquestions;

/**
 *
 * @author Kyoo
 */
public class RemoveDuplicatedElements {
    public static void main(String[] args) {
        String text="asasdakjnckasldkmkmremkas";
        System.out.println(removeDuplicate(text));
    }

    private static String removeDuplicate(String text) {
        boolean[] cars= new boolean[256];
        StringBuilder sB= new StringBuilder("");
        for (int i = 0; i < text.length(); i++){
            char c=text.charAt(i);
            if(!cars[c]){
                sB.append(c);
                cars[c]=true;
            }
        }
        return sB.toString();
    }
}
