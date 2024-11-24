package src.main.kotlin.leetcode;

import java.util.Arrays;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int top=0;
        int bottom= matrix.length-1;
        int left=0;
        int right=matrix[0].length-1;
        int curIndex=0;
        Integer [] ar=new Integer[matrix.length*matrix[0].length];
        while (curIndex<ar.length){
            for (int i = left; i <right &&(curIndex<ar.length) ; i++) {
                ar[curIndex]=matrix[top][i];
                curIndex++;
            }
            for (int i = top; i <bottom&&(curIndex<ar.length) ; i++) {
                ar[curIndex]=matrix[i+1][right];
                curIndex++;
            }
            for (int i = right-1; i>=left&&(curIndex<ar.length) ; i--) {
                ar[curIndex]=matrix[bottom][i];
                curIndex++;
            }
            for (int i = bottom-1; i>=top+1&&(curIndex<ar.length) ; i--) {
                ar[curIndex]=matrix[i][left];
                curIndex++;
            }
            top++;
            bottom--;
            left++;
            right--;
        }
        return Arrays.asList(ar);
    }
}