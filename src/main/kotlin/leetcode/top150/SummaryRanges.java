package src.main.kotlin.leetcode.top150;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans=new ArrayList<>();
        if (nums.length==0){
            return new ArrayList<>();
        }
        if (nums.length==1){
            ans.add(""+nums[0]);
            return ans;
        }
        int left=0;
        int right=0;
        int len=nums.length;

        while (right<len-1 ){
            if ((nums[right]+1)!=nums[right+1]){
                if (left==right){
                    ans.add(""+nums[right]);
                }else{
                    ans.add(nums[left]+"->"+nums[right]);
                }
                left=right+1;
            }
            right++;
        }
        if (nums[len-1]-1 != nums[len-2]){
            ans.add(""+nums[len-1]);
        }else{
            ans.add(nums[left]+"->"+nums[right]);
        }
        return ans;
    }
}
