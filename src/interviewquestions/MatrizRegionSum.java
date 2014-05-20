/*
 * Given a matrix of integers and coordinates of a rectangular region within 
 * the matrix, find the sum of numbers falling inside the rectangle. 
 * Our program will be called multiple times with different rectangular 
 * regions from the same matrix. - See more at:
 * http://www.ardendertat.com/2012/01/09/programming-interview-questions/#sthash.bk8CTgTL.dpuf
 */
package interviewquestions;

/**
 *
 * @author Kyoo
 */
public class MatrizRegionSum {
    public static void main(String[] args) {
        int[][] m={{3,2,12,4,4,1,4},
                   {4,3, 1, 2,5,7,1},
                   {9,7, 5, 3,0,3,4},
                   {1,8, 1, 1,3,4,5},
                   {9,6, 4, 1,1,4,5},
                   {8,4, 3, 1,3,4,1}};
        int x1=1,y1=1, x2=4,y2=5;
        int[][] procesMtx=processMtx( m);
        System.out.println(sum(procesMtx,x1,y1,x2,y2)+"  "+test2(m,x1,y1,x2,y2));
    }
    private static int[][] processMtx(int[][] m) {
        int[][] m2= new int[m.length][m[0].length];
        for (int i = 0; i < m2.length; i++) 
            for (int j = 0; j < m2[0].length; j++) 
                m2[i][j]=m[i][j]+(j>0?m2[i][j-1]:0)+(i>0?m2[i-1][j]:0)-(i>0&&j>0?m2[i-1][j-1]:0);
        return m2;
    }
    private static int sum(int[][] procesMtx, int x1, int y1, int x2, int y2) {
        return procesMtx[x2][y2]-(x1>0?procesMtx[x1-1][y2]:0)-
                (y1>0?procesMtx[x2][y1-1]:0)+(x1>0 && y1>0?procesMtx[x1-1][y1-1]:0);
    }
    private static int test2(int[][] m, int x1, int y1, int x2, int y2) {
        int suma=0;
        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                suma+=m[i][j];
            }
        }
        return suma;
    }

}