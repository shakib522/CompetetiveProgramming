package src.main.kotlin.leetcode.top150;

public class HappyNumber {
    public static void main(String[] args) {
        HappyNumber h = new HappyNumber();
        System.out.println(h.isHappy(1111111));
    }
    public boolean isHappy(int n) {
        if (n==1||n==7){
            return true;
        }else if (n<=9){
            return false;
        }
        return isHappy(sum(n));
    }
    int sum(int n){
        int ans=0;
        while (n>0) {
            int num = n % 10;
            ans+=((num)*(num));
            n=n/10;
        }
        return ans;
    }
}
