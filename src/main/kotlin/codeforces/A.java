package src.main.kotlin.codeforces;

import java.util.*;

public class A {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        int testCase = scan.nextInt();
        while (testCase > 0) {
            solve();
            testCase--;
        }
    }

    public static void solve() {
        int n=scan.nextInt();
        int[] ara =new int[n];
        for (int i = 0; i < n; i++) {
            ara[i]=scan.nextInt();
        }
        for (int i = 1; i <n; i++) {
            int dif=Math.abs(ara[i]-ara[i-1]);
            if (dif!=5 && dif!=7){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}
