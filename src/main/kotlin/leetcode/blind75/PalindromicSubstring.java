package src.main.kotlin.leetcode.blind75;

public class PalindromicSubstring {
    public int countSubstrings(String s) {
        int ans=0;
        for (int i=0;i<s.length();i++){
            for (int j=i+1;j<=s.length();j++){
                if (isPalindrome(s.substring(i,j))){
                    ans++;
                }
            }
        }
        return ans;
    }
    boolean isPalindrome(String str){
        int left=0;
        int right=str.length()-1;
        while (left<right){
            if (str.charAt(left)!=str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
