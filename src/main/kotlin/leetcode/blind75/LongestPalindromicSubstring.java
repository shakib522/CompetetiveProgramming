package src.main.kotlin.leetcode.blind75;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if(s.length()<=1){
            return s;
        }
        int maxLen=0;
        String maxStr="";
        for (int i=0;i<s.length()-1;i++){
            for (int j=i;j<=s.length();j++){
                if (j-i > maxLen && isPalindrome(s.substring(i,j))){
                    maxLen=j-i;
                    maxStr=s.substring(i,j);
                }
            }
        }
        return maxStr;
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
