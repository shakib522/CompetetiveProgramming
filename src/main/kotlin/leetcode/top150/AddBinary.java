package src.main.kotlin.leetcode.top150;

public class AddBinary {
    public String addBinary(String a, String b) {
        int carry=0;
        int right1=a.length()-1;
        int right2=b.length()-1;
        StringBuilder ans=new StringBuilder();
        while (right1>=0 && right2>=0){
            if (a.charAt(right1)=='1'&& b.charAt(right2)=='1'){
                if (carry==1){
                    ans.append('1');
                }else{
                    ans.append('0');
                }
                carry=1;
            }else if (a.charAt(right1)=='0'&& b.charAt(right2)=='0'){
                if (carry==1){
                    ans.append('1');
                }else{
                    ans.append('0');
                }
                carry=0;
            }else{
                if (carry==1){
                    ans.append('0');
                }else{
                    ans.append('1');
                }
            }
            right1--;
            right2--;
        }

        while (right1>=0){
            if (a.charAt(right1)=='1'){
                if (carry==1){
                    ans.append('0');
                }else{
                    ans.append('1');
                }
            }else if (a.charAt(right1)=='0'){
                if (carry==1){
                    ans.append('1');
                }else{
                    ans.append('0');
                }
                carry=0;
            }
            right1--;
        }
        while (right2>=0){
            if (a.charAt(right2)=='1'){
                if (carry==1){
                    ans.append('0');
                }else{
                    ans.append('1');
                }
            }else if (a.charAt(right2)=='0'){
                if (carry==1){
                    ans.append('1');
                }else{
                    ans.append('0');
                }
                carry=0;
            }
            right2--;
        }
        return ans.toString();
    }
}
