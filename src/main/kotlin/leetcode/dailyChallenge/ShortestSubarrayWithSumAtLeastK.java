package src.main.kotlin.leetcode.dailyChallenge;

import src.main.kotlin.Pair;

import java.util.ArrayDeque;
import java.util.Deque;

public class ShortestSubarrayWithSumAtLeastK {
    public int shortestSubarray(int[] nums, int k) {
        Deque<Pair<Long, Integer>> dq = new ArrayDeque<>();
        int shortest = Integer.MAX_VALUE;
        long sum = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
            if(sum>=k){
                shortest=Math.min(shortest,i+1);
            }
            while (!dq.isEmpty() && (sum-dq.getFirst().getFirst() )>= k) {
                Pair<Long, Integer> val = dq.removeFirst();
                shortest= Math.min(shortest,i-val.getSecond());
            }
            while (!dq.isEmpty() && dq.getLast().getFirst() > sum) {
                dq.removeLast();
            }
            dq.addLast(new Pair<>(sum,i));
        }
        return shortest==Integer.MAX_VALUE?-1:shortest;
    }
}
