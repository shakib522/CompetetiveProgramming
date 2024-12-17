package src.main.kotlin;

import java.util.HashSet;
import java.util.Set;

public class ZeroSubArray {
    public static void main(String[] args) {
        int[] ar=new int[]{4,1,6,-3,-1,7,1,3,0,-4};
        Set<Integer> st = new HashSet<>();
        int sum=0;
        for (int i = 0; i < ar.length; i++) {
            sum+=ar[i];
            if (st.contains(sum)){
                System.out.println("SubArray Sum exist");
                return;
            }else {
                st.add(sum);
            }
        }
        System.out.println("Sub array not exist");
    }
}
