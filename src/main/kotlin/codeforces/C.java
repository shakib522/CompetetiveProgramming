package src.main.kotlin.codeforces;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class C {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        int testCase = scan.nextInt();
        while (testCase > 0) {
            solve();
            testCase--;
        }
    }

    public static void solve() {
        int n = scan.nextInt();

        List<Integer> permutation = new ArrayList<>();

        for (int i = 2; i <= n; i += 2) {
            permutation.add(i);
        }
        for (int i = 1; i <= n; i += 2) {
            permutation.add(i);
        }

        // Calculate k based on the given permutation
        int k = 0;
        for (int i = 0; i < n; i++) {
            if ((i + 1) % 2 == 1) {  // If index i + 1 is odd
                k &= permutation.get(i);
            } else {  // If index i + 1 is even
                k |= permutation.get(i);
            }
        }
        System.out.println(k);

    }
}


