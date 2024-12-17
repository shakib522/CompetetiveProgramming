package src.main.kotlin.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ReplaceWithSmallerNumber {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        int[] ar = new int[]{9, 1, 3, 4, 72, 12, 3};
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < ar.length; i++) {
            while (!st.isEmpty() && st.peek() >= ar[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                ans.add("_");
            } else {
                ans.add(String.valueOf(st.peek()));
            }
            st.push(ar[i]);
        }
        System.out.println(ans);
    }
}
