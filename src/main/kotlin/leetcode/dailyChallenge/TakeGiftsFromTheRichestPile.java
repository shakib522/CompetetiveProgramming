package src.main.kotlin.leetcode.dailyChallenge;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class TakeGiftsFromTheRichestPile {
    public long pickGifts(int[] gifts, int k) {
        Comparator<Integer> cmp =new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        };
        PriorityQueue<Integer> pq=new PriorityQueue<>(cmp);
        for (int gift : gifts) {
            pq.add(gift);
        }
        for (int i = 0; i < k; i++) {
            if (!pq.isEmpty()){
                int val=pq.poll();
                pq.add((int) Math.sqrt(val));
            }
        }
        long ans=0;
        while (!pq.isEmpty()){
            ans+=pq.poll();
        }
        return ans;
    }
}
