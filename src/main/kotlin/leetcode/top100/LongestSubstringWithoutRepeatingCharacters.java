package src.main.kotlin.leetcode.top100;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> st=new HashSet<>();
        int left=0;
        int len=s.length();
        int right=0;
        int ans=0;
        while (right<len){
            if (!st.contains(s.charAt(right))){
                st.add(s.charAt(right));
                right++;
            }else{
                ans=Math.max(ans,right-left);
                st.remove(s.charAt(left++));
            }
        }
        return ans;
    }
}
