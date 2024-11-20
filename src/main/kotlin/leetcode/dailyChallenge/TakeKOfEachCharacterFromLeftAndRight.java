package src.main.kotlin.leetcode.dailyChallenge;

public class TakeKOfEachCharacterFromLeftAndRight {
    public int takeCharacters(String s, int k) {
        int[] total=new int[3];
        int len=s.length();
        for (int i = 0; i < s.length(); i++) {
            total[s.charAt(i)-'a']++;
        }
        if (total[0]<k||total[1]<k||total[2]<k){
            return -1;
        }
        int ans=Integer.MAX_VALUE;
        int[] cur=new int[3];
        int l=0;
        int r=0;
        while (r<s.length()){
            cur[s.charAt(r)-'a']++;
            while (l<=r&& (total[0]-cur[0]<k || total[1]-cur[1]<k ||total[2]-cur[2]<k)){
                cur[s.charAt(l)-'a']--;
                l++;
            }
            ans=Math.min(ans,len-(r-l+1));
            r++;
        }
        return ans;
    }
}
