package src.main.kotlin.codeforces;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class C2 {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        int testCase = scan.nextInt();
        while (testCase > 0) {
            solve();
            testCase--;
        }
    }

    public static void solve() {
        scan.nextLine();
        String s=scan.nextLine();
        char[] c=s.toCharArray();
        int q=scan.nextInt();
        Map<Integer,Integer>map=new HashMap<>();
        for (int i = 0; i <= c.length-4; i++) {
            if (c[i]=='1' && c[i+1]=='1' && c[i+2]=='0' && c[i+3]=='0'){
                map.put(i+1,i+4);
            }
        }
        for (int i = 0; i < q; i++) {
            int index= scan.nextInt();
            int val= scan.nextInt();
            char ch= (char) ('0'+ val);
            if (c[index-1]==ch){
                if (map.isEmpty()){
                    System.out.println("NO");
                }else{
                    System.out.println("YES");
                }
                continue;
            }
            c[index-1]=ch;

            for (int j = index; j <index+4 ; j++) {
                if (map.containsKey(j)){
                    map.remove(j);
                }
            }
            for (int j = index-3; j <=index ; j++) {
                if (map.containsKey(j)){
                    map.remove(j);
                }
            }
            if (map.isEmpty()){
                for (int k = 0; k <= c.length-4; k++) {
                    if (c[k]=='1' && c[k+1]=='1' && c[k+2]=='0' && c[k+3]=='0'){
                        map.put(k+1,k+4);
                    }
                }
                if (map.isEmpty()){
                    System.out.println("NO");
                }else{
                    System.out.println("YES");
                }
            }else{
                System.out.println("YES");
            }
        }
    }
}
