package src.main.kotlin.codeforces;

import java.util.*;

public class B {
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
        int k=scan.nextInt();
        Map<Integer,Long> map = new HashMap<>();
        for (int i = 0; i <k; i++) {
            int bi=scan.nextInt();
            int cost=scan.nextInt();
            if (map.containsKey(bi)){
                map.put(bi,map.get(bi)+cost);
            }else{
                map.put(bi,(long)cost);
            }
        }
        List<Map.Entry<Integer,Long>> list = new ArrayList<>(map.entrySet());
        list.sort(new Comparator<Map.Entry<Integer, Long>>() {
            @Override
            public int compare(Map.Entry<Integer, Long> o1, Map.Entry<Integer, Long> o2) {
                return (int) (o2.getValue()-o1.getValue());
            }
        });
       long ans=0;

       int range=Math.min(n,k);
       for (int i=0;i<Math.min(range,list.size());i++){
           ans+=list.get(i).getValue();
       }
        System.out.println(ans);
    }
}
