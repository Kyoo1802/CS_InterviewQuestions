/*
 * Given an image represented by an NxN matrix, where each pixel in the image is 4 
 * bytes, write a method to rotate the image by 90 degrees Can you do this in place?
 */
package crackingcodeinterview.arraystrings;

import java.util.Arrays;

/**
 *
 * @author Kyoo
 */
public class RotateMtx90Degrees {
    public static void main(String[] args) {
        int[][] mtx= new int[][]{{1,2,3,4,5},
                                 {2,3,1,2,2},
                                 {5,2,6,8,1},
                                 {0,3,1,2,4},
                                 {6,34,5,0,4}};
        rotate90d(mtx);
        for (int[] row : mtx)
            System.out.println(Arrays.toString(row));
    }

    private static void rotate90d(int[][] mtx) {
        for (int i = 0; i < mtx.length/2; i++) {
            for (int j = i; j < mtx[i].length-i-1; j++) {
                swap(mtx,i,j,j,mtx[i].length-i-1);
                swap(mtx,i,j,mtx.length-i-1,mtx[i].length-j-1);
                swap(mtx,i,j,mtx.length-j-1,i);
            }
        }
    }
    private static void swap(int[][] mtx, int i1,int j1, int i2,int j2){
        int temp=mtx[i1][j1];
        mtx[i1][j1]=mtx[i2][j2];
        mtx[i2][j2]=temp;
    }
}
