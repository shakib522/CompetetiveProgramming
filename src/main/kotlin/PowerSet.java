package src.main.kotlin;

//print all subsets

import java.util.ArrayList;

public class PowerSet {

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int n=nums.length;
        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
        int subSet = 1<<n;
        for (int i=0;i<subSet;i++){
            ArrayList<Integer> list = new ArrayList<>();
            for (int j=0;j<n;j++){
                if ((i & (1<<j))>=1){
                    list.add(nums[j]);
                }
            }
            arrayList.add(list);
        }
        System.out.println(arrayList);
    }

}
