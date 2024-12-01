package src.main.kotlin.leetcode.dailyChallenge;

import java.util.HashSet;
import java.util.Set;

public class CheckIfNAndItsDoubleExist {
    public boolean checkIfExist(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (set.contains(arr[i]*2)){
                return true;
            }else if((arr[i]&1)==0){
                if (set.contains(arr[i]/2)){
                    return true;
                }else {
                    set.add(arr[i]);
                }
            }else{
                set.add(arr[i]);
            }
        }
        return false;
    }
}
