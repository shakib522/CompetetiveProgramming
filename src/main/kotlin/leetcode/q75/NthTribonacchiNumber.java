package src.main.kotlin.leetcode.q75;

public class NthTribonacchiNumber {
    public static void main(String[] args) {
        NthTribonacchiNumber t= new NthTribonacchiNumber();
        System.out.println(t.tribonacci(4));
    }
    public int tribonacci(int n) {
        if (n==0) return 0;
        if (n==1 || n==2) return 1;
        int prev1=1;
        int prev2=1;
        int prev3=0;
        int ans;
        for (int i = 3; i <=n; i++) {
            ans=prev1+prev2+prev3;
            prev3=prev2;
            prev2=prev1;
            prev1=ans;
        }
        return prev1;
    }
}
