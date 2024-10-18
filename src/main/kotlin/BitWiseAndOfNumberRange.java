package src.main.kotlin;

public class BitWiseAndOfNumberRange {

    public static void main(String[] args) {
        System.out.println(rangeBitwiseAnd(5, 121));
    }

    public static int rangeBitwiseAnd(int left, int right) {
        int cnt = 0;
        while (right != left) {
            right = right >> 1;
            left = left >> 1;
            cnt++;
        }
        return (right << cnt);
    }
}
