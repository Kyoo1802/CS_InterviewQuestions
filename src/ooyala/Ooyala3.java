package ooyala;


import java.util.Arrays;

public class Ooyala3 {
    public static void main(String[] args) {
        int arr[] = {3, 4, 10, 21, 34, 35, 112};
        BinaryTree bt= new BinaryTree(arr);
        System.out.println(bt);
        int toArr[]= new int[arr.length];
        bt.toArray(toArr);
        System.out.println(Arrays.toString(toArr));
    }
    
    static class BinaryTree{
        Node root;
        static int idx=0;
        public BinaryTree(int[] arr){
            root=add(arr,0, arr.length-1);
        }        
        private Node add(int arr[], int a, int b) {
            if (b < a)
                return null;
            int middle = (a + b) / 2;
            Node n = new Node(arr[middle]);
            n.left = add(arr, a, middle - 1);
            n.right = add(arr, middle + 1, b);
            return n;
        }
        private String traversal(Node node) {
            if(node==null)
                return "";
            return traversal(node.left)+node+", "+ traversal(node.right);
        }

        public void toArray(int[] toArr) {
            idx=0;
            toArray(root, toArr);
        }
        private void toArray(Node node, int[] toArr){
            if(node==null)
                return;
            toArray(node.left,toArr);
            toArr[idx++]=node.value;
            toArray(node.right,toArr);
        }
        
        public String toString(){
            return traversal(root);
        }
    }
    static class Node{
        int value;
        Node left, right;
        public Node(int value){
            this.value=value;
        }
        public String toString(){
            return value+"";
        }
    }
}
