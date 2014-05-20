/*
 * Given a linkedlist of integers and an integer value, delete every node of 
 * the linkedlist containing that value. - See more at: 
 * http://www.ardendertat.com/2012/01/09/programming-interview-questions/#sthash.bk8CTgTL.dpuf
 */
package interviewquestions;

/**
 *
 * @author Kyoo
 */
public class LinkedListRemoveNodes {
    public static void main(String[] args) {
        Node root=null;
        root=add(root,1);
        root=add(root,2);
        root=add(root,5);
        root=add(root,5);
        System.out.println(root);
        root=remove(root, 5);
        System.out.println(root);
    }
    static Node add(Node n, int v){
        if(n==null)
            return new Node(v);
        Node root=n;
        while(n.next!=null) n=n.next;
        n.next=new Node(v);
        return root;
    }
    static Node remove(Node n, int v){
        Node root=n;
        while(n!=null && n.v==v){
            root=n=n.next;
        }
        if(n==null)
            return null;
        Node past=n;
        n=n.next;
        while(n!=null){
            if(n.v==v)
                past.next=n.next;
            else
                past=n;
            n=n.next;
        }
        return root;
    }
    static class Node{
        int v;
        Node next;
        public Node(int v){
            this.v=v;
        }
        @Override
        public String toString(){
            String r="";
            Node n=this;
            do{
                r+=n.v+", ";
                if(n!=null)
                    n=n.next;
            }while(n!=null);
            return r;
        }
    }
}
