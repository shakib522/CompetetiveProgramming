package src.main.kotlin.leetcode.dailyChallenge;

public class FindThePowerOfKSizeSubarrays1 {
    public int[] resultsArray(int[] nums, int k) {
        int len=nums.length;
        int[] ans=new int[len-k+1];
        for (int i=0;i<=len-k;i++){
            boolean flag=false;
            int j=0;
            for ( j = i; j < i+k-1; j++) {
                if (nums[j]+1!=nums[j+1]){
                    ans[i]=-1;
                    flag=true;
                    break;
                }
            }
            if (!flag){
                ans[i]=nums[j];
            }
        }
        return ans;
    }
    public int[] resultsArray2(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            return new int[0];
        }

        int[] arr =new int[nums.length-k+1];
        int i=0;
        int j=k-1;
        int a=0;
        while(j<nums.length){
            if(solved(nums,i,j)){
                arr[a]=nums[j];
            }
            else{
                arr[a]=-1;
            }
            i++;
            j++;
            a++;
        }
        return arr;
    }
    private boolean solved(int[] nums, int start, int end){
        for(int i=start;i<end;i++){
            if(nums[i]+1!=nums[i+1]){
                return false;
            }
        }
        return true;
    }
}
