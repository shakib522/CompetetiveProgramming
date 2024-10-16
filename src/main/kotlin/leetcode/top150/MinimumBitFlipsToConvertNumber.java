package src.main.kotlin.leetcode.top150;

public class MinimumBitFlipsToConvertNumber {
    public int minBitFlips(int start, int goal) {
        int ans=start^goal; //contain some 1 which is the number of flip bit.xor operation can differentiate between bits.when two bits are different, result is 1.and when two bit are same result is 0.So we just count the number of 1 after xor operations.
        int cnt=0;
        for (int i=0;i<31;i++){
            if ((ans & (1<<i))>1){
                cnt++;
            }
        }
        return cnt;
    }
}
