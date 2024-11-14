package src.main.kotlin.codeforces;

import java.util.Scanner;

public class APerpendicularSegments {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int test=scanner.nextInt();
        for (int i=0;i<test;i++){
            int x,y,k;

            x=scanner.nextInt();
            y=scanner.nextInt();
            k=scanner.nextInt();
            int min=Math.min(x,y);
            System.out.println("0 0 "+min+" "+min);
            System.out.println("0 "+min+" "+min+" 0");
        }
    }
}
