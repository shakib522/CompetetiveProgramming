package src.main.kotlin.leetcode.top150;

public class Sqrtx {
    public static void main(String[] args) {
        System.out.println(mySqrt2(11));
    }
    public int mySqrt(int x) {
        if (x == 1 || x == 2 || x == 3) {
            return 1;
        }
        for (int i = 0; i <= x / 2; i++) {
            long sq = (long) i * i;
            if (sq == x) {
                return i;
            } else if (sq > x) {
                return i - 1;
            }
        }
        return 0;
    }

    public static int mySqrt2(int x) {
        if (x == 1 || x == 2 || x == 3) {
            return 1;
        }
        int left = 0;
        int right = x;
        int mid = 0;
        while (left < right) {
            mid = left + (right - left) / 2;
            long f = (long) mid * mid;
            if (f == x) {
                return mid;
            } else if (f > x) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        if (left*left<=x) return left;
        else return left-1;
    }
}
