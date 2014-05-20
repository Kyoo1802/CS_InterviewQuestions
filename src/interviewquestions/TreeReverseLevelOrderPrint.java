/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewquestions;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Kyoo
 */
public class TreeReverseLevelOrderPrint {
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
        Queue<Node> queue= new LinkedList<>();
        Deque<Node> stackLvl= new LinkedList<>();
        Deque<Integer> numNodesLvl= new LinkedList<>();
        int countLvl=1;
        int newLvl=0;
        queue.add(n);
        numNodesLvl.add(countLvl);
        while(!queue.isEmpty()){
            Node current=queue.poll();
            stackLvl.push(current);
            if(current.right!=null){
                queue.offer(current.right);
                newLvl++;
            }
            if(current.left!=null){
                queue.offer(current.left);
                newLvl++;
            }
            countLvl--;
            if(countLvl==0 && newLvl>0){
                numNodesLvl.push(newLvl);
                countLvl=newLvl;
                newLvl=0;
            }
        }
        while(!numNodesLvl.isEmpty()){
            int numNodes=numNodesLvl.pop();
            for (int i = 0; i < numNodes; i++)
                System.out.print(stackLvl.pop().v+" ");
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
