package src.main.kotlin.leetcode.dailyChallenge;

import java.util.Arrays;

public class MinimizedMaximumOfProductsDistributedToAnyStore {
    public static void main(String[] args) {
        System.out.println(minimizedMaximum(6,new int[]{11,6}));
    }
    public static int minimizedMaximum(int n, int[] quantities) {
        int high= Arrays.stream(quantities).max().getAsInt();
        int low=0;
        int ans2=0;
        while (low<=high){
            int mid=low+(high-low)/2;
            int ans=0;
            for (int i = 0; i < quantities.length; i++) {
                ans+=(quantities[i]/mid);
                if (quantities[i]%mid!=0){
                    ans++;
                }
            }
            if(ans<=n){
                ans2=mid;
            }
            if (ans>n){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return ans2;
    }
}
