package src.main.kotlin.leetcode.top150;

public class MaximumSubarray {
    public static void main(String[] args) {
        MaximumSubarray max=new MaximumSubarray();
        System.out.println(max.maxSubArray2(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
    public int maxSubArray(int[] nums) {
        int result=nums[0];
        int maxSubarray=nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxSubarray=Math.max(maxSubarray+nums[i],nums[i]);
            result=Math.max(result,maxSubarray);
        }
        return result;
    }
    public int maxSubArray2(int[] nums) {
        int indexStart=-1;
        int indexEnd=-1;
        int result=Integer.MIN_VALUE;
        int maxSubarray=0;
        for (int i = 0; i < nums.length; i++) {
            maxSubarray+=nums[i];
            if (maxSubarray>result){
                result=maxSubarray;
                indexEnd=i;
            }
            if (maxSubarray<0){
                indexStart=i+1;
                maxSubarray=0;
            }
        }
        System.out.println("index start: "+indexStart);
        System.out.println("indexEnd : "+indexEnd);
        for (int i = indexStart; i <=indexEnd ; i++) {
            System.out.print(nums[i]+" ");
        }
        System.out.println();
        return result;
    }
}
