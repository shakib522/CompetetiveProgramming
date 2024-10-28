package src.main.kotlin.codeforces;

import java.util.Scanner;

public class A {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        int testCase = scan.nextInt();
        while (testCase>0){
            solve();
            testCase--;
        }
    }
    public static void solve(){
        long n,m,r,c;
        n=scan.nextLong();
        m=scan.nextLong();
        r=scan.nextLong();
        c=scan.nextLong();
        long totalElement=  n *m;
        long removeElement=( (r - 1) *m)+c;
        long remainingElement=totalElement-removeElement;
        if (n==r){
            System.out.println(remainingElement);
        }else{
            System.out.println(remainingElement - (n-r) + (m*(n-r)));
        }
    }
}
