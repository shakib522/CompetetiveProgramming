package src.main.kotlin.hackerrank;

import java.util.*;

public class FlipColumns {
    public static void main(String[] args) {
        int n, m, k, ans = Integer.MIN_VALUE;
        Map<String, Integer> frequency = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        k = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int zeros = 0;
            StringBuilder tmp = new StringBuilder();
            for (int j =0 ; j<m;j++){
                int x=scanner.nextInt();
                if (x==0) zeros++;
                tmp.append(x);
            }
            if (zeros<=k && (k-zeros)%2==0){
               frequency.put(tmp.toString(),frequency.getOrDefault(tmp.toString(),0)+1);
            }
        }
        Collection<Integer> f = frequency.values();
        for (Integer val:f){
            if (val>ans) ans=val;
        }
        System.out.println(ans);
    }
}
