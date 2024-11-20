package src.main.kotlin.leetcode.dailyChallenge;

public class DefuseTheBomb {
    public int[] decrypt(int[] code, int k) {
        int len=code.length;
        int[] ans=new int[len];
        if (k==0){
            for (int i = 0; i <len ; i++) {
                code[i]=0;
            }
            return code;
        }else if(k>0){
            for (int i = 0; i <len ; i++) {
                int sum=0;
                for (int j = i+1; j <i+1+k; j++) {
                    sum+=code[j%len];
                }
                ans[i]=sum;
            }
        }else{
            for (int i = 0; i <len ; i++) {
                int sum=0;
                int j=i-1;
                int cnt=0;
                while (cnt<Math.abs(k)){
                    if (j<0){
                        j=len+j;
                    }
                    if (cnt==k){
                        break;
                    }
                    sum+=code[j];
                    j--;
                    cnt++;
                }
                ans[i]=sum;
            }
        }
        return ans;
    }
    public int[] decrypt2(int[] code, int k) {
        int len=code.length;
        int[] ans=new int[len];
        if (k==0) {
            return ans;
        }
        int start=1;
        int end=k;
        if(k<0){
            start=len-Math.abs(k);
            end=len-1;
        }
        int sum=0;
        for (int i = start; i <=end ; i++) {
            sum+=code[i];
        }
        for (int i = 0; i <len; i++) {
            ans[i]=sum;
            sum-=code[start%len];
            sum+=code[end+1%len];
            start++;
            end++;

        }
        return ans;
    }
}
