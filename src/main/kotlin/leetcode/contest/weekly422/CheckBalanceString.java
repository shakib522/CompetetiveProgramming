package src.main.kotlin.leetcode.contest.weekly422;

public class CheckBalanceString {
    public static void main(String[] args) {
        CheckBalanceString c=new CheckBalanceString();
        System.out.println(c.isBalanced("1342"));
    }
    public boolean isBalanced(String num) {
        int sumOdd=0;
        int sumEven=0;
        for (int i = 0; i < num.length(); i++) {
            int val=(num.charAt(i)-48);
            if ((i&1)==1){
                sumOdd+=val;
            }else{
                sumEven+=val;
            }
        }
        return sumEven==sumOdd;
    }
}
