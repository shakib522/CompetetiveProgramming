package src.main.kotlin;

import java.util.Scanner;

public class XOROfNumbersInAGivenRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(xorOfNumbersFromZeroToN(n));
        int l= scanner.nextInt();
        int r=scanner.nextInt();
        System.out.println(xorOfNumbersFromGivenRange(l,r));
    }
    static int xorOfNumbersFromGivenRange(int l,int r){
        return xorOfNumbersFromZeroToN(l-1)^xorOfNumbersFromZeroToN(r);
    }
    static int xorOfNumbersFromZeroToN(int n){
        if (n%4==1){
            return 1;
        }else if(n%4==2){
            return n+1;
        }else if(n%4==3){
            return 0;
        }else if(n%4==0){
           return n;
        }
        return n;
    }
}
