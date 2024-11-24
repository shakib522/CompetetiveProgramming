package src.main.kotlin.leetcode;

import java.util.Arrays;

public class SpiralMatrix2 {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(generateMatrix(4)));
    }
    public static int[][] generateMatrix(int n) {
        int [][] matrix=new int[n][n];
        int top=0;
        int bottom= n-1;
        int left=0;
        int right=n-1;
        int val=1;
        int limit=n*n;
        while (val<=limit){
            System.out.println("val: "+val);
            for (int i = left; i <=right &&(val<=limit) ; i++) {
                matrix[top][i]=val;
                val++;
            }
            for (int i = top; i <bottom&&(val<=limit) ; i++) {
               matrix[i+1][right]=val;
                val++;
            }
            for (int i = right-1; i>=left&&(val<=limit) ; i--) {
                matrix[bottom][i]=val;
                val++;
            }
            for (int i = bottom-1; i>=top+1&&(val<=limit) ; i--) {
                matrix[i][left]=val;
                val++;
            }
            top++;
            bottom--;
            left++;
            right--;
        }
        return matrix;
    }
}
