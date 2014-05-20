/*
 * How would you write a function traversal of a square matrix in diagonal strips.
 */
package interviewquestions;

/**
 *
 * @author Kyoo
 */
public class DiagonalTraverseMatrix {
    public static void main(String[] args) {
        int[][] mtx= {{1,2,3},{4,5,6},{7,8,9}};
        diagonalTraverse(mtx);
    }

    private static void diagonalTraverse(int[][] mtx) {
        for (int i = 0; i < mtx.length+mtx[0].length-1; i++) {
            int r=i<mtx[0].length?0:i-mtx[0].length+1,c=i<mtx[0].length?i:mtx[0].length-1;
            while (r<mtx.length && c>=0)
                System.out.print(mtx[r++][c--]+", ");
            System.out.println("");
        }
    }
}
