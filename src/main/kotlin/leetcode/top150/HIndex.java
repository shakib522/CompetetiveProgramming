package src.main.kotlin.leetcode.top150;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class HIndex {
    public static void main(String[] args) {

        int number = 10; // Effectively final
        Runnable r = () -> System.out.println(number);
        // number = 20; // This would cause a compilation error.
        r.run();

        Integer [] ar={2,5,1,7,2,78,11};
        Comparator<Integer> cmp = new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        };
        final int f=10;
//        Arrays.sort(ar, cmp);
        Arrays.sort(ar, Collections.reverseOrder());
        System.out.println(Arrays.toString(ar));
    }

    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int ans=Integer.MIN_VALUE;
        int n=citations.length;
        for(int i=0;i<n;i++){
            if((n-i)<= citations[i]){
                return n-i;
            }
        }
        return 0;
    }
}
