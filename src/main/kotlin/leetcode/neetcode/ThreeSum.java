package src.main.kotlin.leetcode.neetcode;

import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        ThreeSum threeSum=new ThreeSum();
        System.out.println(threeSum.threeSum2(new int[]{-1,0,1,2,-1,-4}));
    }
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> st = new HashSet<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            Set<Integer> cache = new HashSet<>();
            for (int j = i + 1; j < len; j++) {
                int num = -(nums[i] + nums[j]);
                if (cache.contains(num)) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(num);
                    Collections.sort(list);
                    st.add(list);
                }
                cache.add(nums[j]);
            }
        }
        return st.stream().toList();
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len; i++) {
//            System.out.println("for loop");
            int left = i + 1;
            int right = len - 1;
            while (left < right) {
//                System.out.println("while loop");
//                System.out.println("left: "+left);
//                System.out.println("right: "+right);
//                System.out.println("i: "+i);
                if (nums[i] + nums[left] + nums[right] == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    ans.add(list);
                    left++;
                    right--;
                    while (left < len && nums[left] == nums[left - 1]) {
//                        System.out.println("left while");
                        left++;
                    }
                    while (right >= 0 && nums[right] == nums[right + 1]) {
//                        System.out.println("right while");
                        right--;
                    }
                } else if (nums[i] + nums[left] + nums[right] < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return ans.stream().toList();
    }
}
