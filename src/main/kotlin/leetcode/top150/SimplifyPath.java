package src.main.kotlin.leetcode.top150;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SimplifyPath {
    public static void main(String[] args) {
        String str =   "/.../b/d";
    }
    public String simplifyPath(String path) {
        String[] c = path.split("/");
        Stack<String> st = new Stack<>();
        for (String ch:c){
            if (!ch.isEmpty() && !ch.equals(".")){
                if (ch.length()==2&&ch.charAt(0)=='.'&&ch.charAt(1)=='.'){
                    if (!st.isEmpty()) st.pop();
                }else {
                    st.push(ch);
                }
            }
        }
        StringBuilder ans = new StringBuilder("/");
        List<String> list = new ArrayList<>(st);
        int len=list.size();
        for (int i=0;i<len;i++){
            if (i==len-1){
                ans.append(list.get(i));
            }else{
                ans.append(list.get(i)).append("/");
            }
        }
        return ans.toString();
    }
}
