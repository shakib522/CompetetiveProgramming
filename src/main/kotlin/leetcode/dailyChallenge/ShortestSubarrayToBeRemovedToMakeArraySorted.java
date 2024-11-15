package src.main.kotlin.leetcode.dailyChallenge;

public class ShortestSubarrayToBeRemovedToMakeArraySorted {
    public int findLengthOfShortestSubarray(int[] arr) {
        int p1=0;
        int len=arr.length;
        int p2=arr.length-1;
        while (p1<len-1){
            if (arr[p1]<=arr[p1+1]){
                p1++;
            }else{
                break;
            }
        }
        while (p2>0){
            if (arr[p2]>=arr[p2-1]){
                p2--;
            }else{
                break;
            }
        }
        int result = Math.min(len - p1 - 1, p2);
        int i = 0, j = p2;
        while (i <= p1 && j < len) {
            if (arr[i] <= arr[j]) {
                result = Math.min(result, j - i - 1);
                i++;
            } else {
                j++;
            }
        }
        return Math.max(0,result);
    }
}
