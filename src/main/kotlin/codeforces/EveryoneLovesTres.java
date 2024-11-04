package src.main.kotlin.codeforces;

import java.util.Scanner;

public class EveryoneLovesTres {
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
        String even = "3366";
        String odd = "36366";
        if (n==1){
            System.out.println("-1");
            return;
        }
        if (n==2){
            System.out.println("66");
            return;
        }
        if (n==3){
            System.out.println("-1");
            return;
        }
        if ((n &1) == 0) {
            int concat = n - 4;
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < concat; i++) {
                builder.append("3");
            }
            System.out.println(builder+even);
            return;
        } else {
            int concat = n - 5;
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < concat; i++) {
                builder.append("3");
            }
            System.out.println(builder+odd);
            return;
        }
    }
}
