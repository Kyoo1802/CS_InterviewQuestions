package ooyala;


import java.util.Arrays;

public class Ooyala2 {
    public static void main(String[] args) {
        System.out.println(12%18);
        int values[]={4,21,34,5,5,31,3,4,5,6,4,2,12,3,2};
        int tempAr[]= new int[1024];
        for (int i = 0; i < values.length; i++)
            tempAr[values[i]]++;
        
        
        for (int i = 0,c=0; i < tempAr.length; i++) {
            for (int j = 0; j < tempAr[i]; j++)
                values[c++]=i;
        }
        System.out.println(Arrays.toString(values));
    }
}
