package src.main.kotlin.codeforces;

import java.util.Scanner;

public class NewYearsEve {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long n = scan.nextLong();
        long k = scan.nextLong();
        if (k == 1) {
            System.out.println(n);
        } else {
            long ans = 1;
            while (n >= ans) {
                ans = ans << 1;
            }
            System.out.println(ans - 1);
        }
    }
}
