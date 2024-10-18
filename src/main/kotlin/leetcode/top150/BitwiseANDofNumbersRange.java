package src.main.kotlin.leetcode.top150;

public class BitwiseANDofNumbersRange {
    public static void main(String[] args) {
        System.out.println(rangeBitwiseAnd(2147483646,2147483647));
    }
    public static int rangeBitwiseAnd(int left, int right) {
        long ans=left;
        for (int i=left;i<=right;i++){
            ans= ans& i;
            if (ans==0){
                return 0;
            }
        }
        return (int)ans;
    }
}
