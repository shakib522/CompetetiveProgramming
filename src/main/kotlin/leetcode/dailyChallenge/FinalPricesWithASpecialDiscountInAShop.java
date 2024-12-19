package src.main.kotlin.leetcode.dailyChallenge;

import java.util.Stack;

public class FinalPricesWithASpecialDiscountInAShop {
    public int[] finalPrices(int[] prices) {
        Stack<Integer> st = new Stack<>();
        int n=prices.length;
        for (int i = n-1; i >=0 ; i--) {
            while (!st.isEmpty() && st.peek()>prices[i]){
                st.pop();
            }
            if (!st.isEmpty()){
                int subtract=st.peek();
                st.push(prices[i]);
                prices[i]=prices[i]-subtract;
            }else{
                st.push(prices[i]);
            }
        }
        return prices;
    }
}
