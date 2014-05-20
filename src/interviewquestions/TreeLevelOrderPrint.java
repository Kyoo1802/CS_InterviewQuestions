/*
 * This is very similar to the previous post level order print. We again print 
 * the tree in level order, but now starting from bottom level to the root. 
 * - See more at: 
 * http://www.ardendertat.com/2012/01/09/programming-interview-questions/#sthash.2pMXnjIl.dpuf
 */
package interviewquestions;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author Kyoo
 */
public class TreeLevelOrderPrint {
    public static void main(String[] args) {
        Node n1= new Node(1);
        Node n2= new Node(2);
        Node n3= new Node(3);
        Node n4= new Node(4);
        Node n5= new Node(5);
        Node n6= new Node(6);
        n1.left=n2;
        n1.right=n3;
        n2.left=n4;
        n3.left=n5;
        n3.right=n6;
        printBFS(n1);
    }
    static void printBFS(Node n){
        Queue<Node> q= new LinkedList<>();
        q.add(n);
        while(!q.isEmpty()){
            List<Node> lvl= new LinkedList<>();
            while(!q.isEmpty())
                lvl.add(q.poll());
            for (Node node : lvl){
                System.out.print(node.v+" ");
                if(node.left!=null)
                    q.offer(node.left);
                if(node.right!=null)
                    q.offer(node.right);
            }
            System.out.println("");
        }
    }
    static class Node{
        int v;
        Node left,right;
        public Node(int v){
            this.v=v;
        }
    }
}
