package src.main.kotlin.leetcode.q75;

public class CountingBits {
    public int[] countBits(int n) {
        int [] ara = new int[n+1];
        for (int i=0;i<=n;i++){
            int cnt=0;
            int num=i;
            while (num!=0){
                num = num&(num-1);
                cnt++;
            }
            ara[i]=cnt;
        }
        return ara;
    }
    public int[] countBitsAnotherApproach(int n) {
        int [] ara = new int[n+1];
        for (int i=1;i<=n;i++){
            ara[i]=ara[i>>1] + (i&1);
            //ara[i>>1] here we divide i by two.
            // i&1 we check if i even or odd.
        }
        return ara;
    }
}
