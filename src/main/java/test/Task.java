package test;

public class Task {
    public static void main(String[] args) {
        int[][] matrix =  {
                {0, 1, 3, 1, 5},
                {3, 0, 2, 0, 2},
                {3, 1, 3, 2, 0},
                {2, 4, 2, -1, 0},
                {5, 0, 3, 9, 9}};
        System.out.println(maxSum(matrix, 2));
    }
    public static int maxSum(int[][] matrix, int windowSize){
        int currentMax = 0;

        for(int x=0;x < matrix.length; x++){
            for(int y=0; y < matrix[x].length; y++){
                int newMax = getLocalMax(matrix, x,y,windowSize);
                if(newMax > currentMax){
                    currentMax = newMax;
                }
            }
        }
        return currentMax;
    }
    public static int getLocalMax(int[][] matrix, int x, int y, int windowSize) {
        int value = 0;
        int verticalBound = Math.min(y+windowSize, matrix[0].length);
        int horizontalBound = Math.min(x+windowSize, matrix.length);

        if(horizontalBound-x == 1 || verticalBound-y == 1){
            return value;
        }
        for (int xx = x; xx < horizontalBound; xx++) {
            for (int yy = y; yy < verticalBound; yy++) {
                value = value + matrix[xx][yy];
            }
        }
        return value;
    }
}
