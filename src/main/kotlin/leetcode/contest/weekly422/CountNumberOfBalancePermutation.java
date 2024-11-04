package src.main.kotlin.leetcode.contest.weekly422;

import java.util.HashSet;
import java.util.Set;

public class CountNumberOfBalancePermutation {
    public static void main(String[] args) {
        CountNumberOfBalancePermutation b =new CountNumberOfBalancePermutation();
        b.countBalancedPermutations("123456789");
    }
    public int countBalancedPermutations(String num) {
        Set<String> set=permutationReturn("",num);
        for (String s:set) {
            System.out.println(s);
        }
        return 1;
    }

    Set<String> permutationReturn(String p, String up) {
        Set<String> ans= new HashSet<>();
        if(up.isEmpty()){
            ans.add(p);
            return ans;
        }
        char ch=up.charAt(0);
        for (int i=0 ;i<=p.length();i++){
            String f=p.substring(0,i);
            String s=p.substring(i);
            ans.addAll(permutationReturn(f+ch+s,up.substring(1)));
        }
        return ans;
    }
}
