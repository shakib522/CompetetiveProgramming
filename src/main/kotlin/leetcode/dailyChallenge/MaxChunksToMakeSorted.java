package src.main.kotlin.leetcode.dailyChallenge;

import java.util.Stack;

public class MaxChunksToMakeSorted {
    public int maxChunksToSorted(int[] arr) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (st.isEmpty() || st.peek()<arr[i]){
                st.push(arr[i]);
            }else{
                int max=st.peek();
                while (!st.isEmpty() && st.peek()>arr[i]){
                    st.pop();
                }
                st.push(max);
            }
        }
        return st.size();
    }
}
