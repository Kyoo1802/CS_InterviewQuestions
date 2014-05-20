/*
 * Write an algorithm such that if an element in an MxN matrix is 0, its entire row and 
 * column is set to 0 
 */
package crackingcodeinterview.arraystrings;

import java.util.Arrays;

/**
 *
 * @author Kyoo
 */
public class ReplaceRowColumn0 {
    public static void main(String[] args) {
        int[][] mtx= new int[][]{{1,2,3,4,5},{2,3,1,2,2},{0,3,1,2,4},{6,34,5,0,4}};
        replaceRowColumn0(mtx);
        for (int[] row : mtx)
            System.out.println(Arrays.toString(row));
    }

    private static void replaceRowColumn0(int[][] mtx) {
        int[] rows= new int[mtx.length];
        int[] cols= new int[mtx[0].length];
        
        for (int i = 0; i < mtx.length; i++) 
            for (int j = 0; j < mtx[i].length; j++) 
                if(mtx[i][j]==0){
                    rows[i]=1;
                    cols[j]=1;
                }
        for (int i = 0; i < mtx.length; i++) 
            for (int j = 0; j < mtx[i].length; j++) 
                if(rows[i]==1||cols[j]==1)
                    mtx[i][j]=0;
    }
}
