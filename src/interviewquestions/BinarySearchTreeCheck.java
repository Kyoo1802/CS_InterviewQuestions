/*
 * Given a binary tree, check whether it’s a binary search tree or not. 
 * - See more at: 
 * http://www.ardendertat.com/2012/01/09/programming-interview-questions/#sthash.bk8CTgTL.dpuf
 */
package interviewquestions;

/**
 *
 * @author Kyoo
 */
public class BinarySearchTreeCheck {
    static int PAST_VALUE=Integer.MIN_VALUE;
    public static void main(String[] args) {
        Node n = null;
        System.out.println(isBST(n));
    }
//Post order comparing the min value
    private static boolean isBST(Node n) {
        if(n==null)
            return true;
        if(!isBST(n.left) || PAST_VALUE>n.v)
            return false;
        PAST_VALUE=n.v;
        return isBST(n.right);
    }
    static class Node{
        Node left, right;
        int v;
        
    }
}
