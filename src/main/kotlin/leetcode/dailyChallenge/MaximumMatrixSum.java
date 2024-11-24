package src.main.kotlin.leetcode.dailyChallenge;

public class MaximumMatrixSum {
    public long maxMatrixSum(int[][] matrix) {
        int n=matrix.length;
        long sum=0;
        int negativeCount=0;
        int min=Integer.MAX_VALUE;
        boolean containZero=false;
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j]<0){
                    int num=(matrix[i][j]*(-1));
                    sum+=num;
                    negativeCount++;
                    if (num<min){
                        min=num;
                    }
                }else if(matrix[i][j]==0){
                    containZero=true;
                }
                else{
                    if (matrix[i][j]<min){
                        min=matrix[i][j];
                    }
                    sum+=matrix[i][j];
                }
            }
        }
        if (!containZero &&(negativeCount&1)==1){
            sum-=(2L *min);
        }
        return sum;
    }
}
