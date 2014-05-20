/*
 * Given a stream of unsorted integers, find the median element in sorted order 
 * at any given time. So, we will be receiving a continuous stream of numbers 
 * in some random order and we don’t know the stream length in advance. Write a 
 * function that finds the median of the already received numbers efficiently at 
 * any time. We will be asked to find the median multiple times. Just to recall, 
 * median is the middle element in an odd length sorted array, and in the even 
 * case it’s the average of the middle elements. - See more at: 
 * http://www.ardendertat.com/2012/01/09/programming-interview-questions/#sthash.bk8CTgTL.dpuf
 */
package interviewquestions;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 * @author Kyoo
 */
public class MedianOfIntegerStream {
    static PriorityQueue<Integer> pQDer,pQIzq;    
    static int N;
    static final Comparator COMP_INVERSE= new Comparator<Integer>(){
        @Override
        public int compare(Integer t1, Integer t2) {
            return Integer.compare(t2, t1);
        }
    };
    public static void main(String[] args) {
        pQIzq= new PriorityQueue<>(50, COMP_INVERSE);
        pQDer= new PriorityQueue<>();
        add(2);
        System.out.println(getMedian());
        add(3);
        System.out.println(getMedian());
        add(6);
        System.out.println(getMedian());
        add(4);
        System.out.println(getMedian());
        add(5);
        System.out.println(getMedian());
        add(1);
        System.out.println(getMedian());
        add(4);
        System.out.println(getMedian());
    }

    private static void add(int v) {
        if(N%2==0){
            if(!pQDer.isEmpty() && pQDer.peek()<v){
                pQIzq.add(pQDer.poll());
                pQDer.add(v);
            }
            else
                pQIzq.add(v);
        }
        else{
            if(!pQIzq.isEmpty() && pQIzq.peek()>v){
                pQDer.add(pQIzq.poll());
                pQIzq.add(v);
            }
            else
                pQDer.add(v);
        }
        System.out.println(pQIzq+" "+pQDer);
        N++;
    }

    private static double getMedian() {
        if(N%2==0)
            return (pQDer.peek()+pQIzq.peek())/2d;
        else
            return pQIzq.peek();
    }
}
