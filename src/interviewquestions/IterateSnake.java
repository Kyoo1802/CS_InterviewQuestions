package interviewquestions;

class IterateSnake {
    public static void roll_snake(Integer[] matrix, Integer width) {
        StringBuilder answ=new StringBuilder("");
        int midW=width/2;
        for (int i = 0; i < midW; i++) {
            int internalW=width-i*2;
            for (int j = 0; j < internalW; j++)
                answ.append(matrix[i*width+j+i]).append(" ");
            for (int j = 1; j < internalW; j++)
                answ.append(matrix[(j+i+1)*width-i-1]).append(" ");
            for (int j = 1; j < internalW; j++)
                answ.append(matrix[(width-i)*width-1-j-i]).append(" ");
            for (int j = 1; j < internalW-1; j++)
                answ.append(matrix[(width-i-j-1)*width+i]).append(" ");
        }
        if(width%2!=0)
            answ.append(matrix[width*(width/2)+width/2]);
        System.out.println(answ.toString().trim());
    }
    public static void main(String[] args) {
        roll_snake(new Integer[]{1},1);
        roll_snake(new Integer[]{1,2,3,4},2);
        roll_snake(new Integer[]{1,2,3,4,5,6,7,8,9},3);
        roll_snake(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16},4);
        roll_snake(new Integer[]{
            3, 4, 8, 7, 9, 
            1, 2, 3, 4, 5, 
            0, 4, 6, 7, 8,
            6, 9, 1, 2, 4,
            5, 7, 3, 2, 8},5);
    }
}