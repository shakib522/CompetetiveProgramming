package src.main.kotlin.leetcode.dailyChallenge;

import java.util.HashSet;
import java.util.Set;

public class MaximumNumberOfIntegersToChooseFromARange {
    public int maxCount(int[] banned, int n, int maxSum) {
        Set<Integer> st = new HashSet<>();
        for(int ban:banned){
            if (ban<=n && ban>=1){
                st.add(ban);
            }
        }
        int count=0;
        int sum=0;
        for (int i = 1; i <=n; i++) {
            if (!st.contains(i) && sum+i<maxSum){
                sum+=i;
                count++;
            }
        }
        return count;
    }
}
