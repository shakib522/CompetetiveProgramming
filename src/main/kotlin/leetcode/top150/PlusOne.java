package src.main.kotlin.leetcode.top150;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        int len=digits.length;
        if (digits[len-1]!=9){
            digits[len-1]++;
            return digits;
        }
        int carry=0;
        for (int i=len-1;i>=0;i--){
            if (digits[i]==9){
                if (i==len-1||carry==1){
                    digits[i]=0;
                    carry=1;
                }
            }else{
                digits[i]+=carry;
                carry=0;
            }
        }
        if (carry==1){
            int[] ans = new int[len+1];
            for (int i=1;i<=len;i++){
                ans[i]=digits[i-1];
            }
            ans[0]=carry;
            return ans;
        }
        return digits;
    }
    public int[] plusOne2(int[] digits) {
        int len=digits.length;
        for (int i=len-1;i>=0;i--){
            if (digits[i]<9) {
                digits[i]++;
                return digits;
            }
            digits[i]=0;
        }
        int[] ans = new int[len+1];
        ans[0]=1;
        return ans;
    }
}
