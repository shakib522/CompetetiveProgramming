package src.main.kotlin.leetcode.neetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EncodeDecode {

    public static void main(String[] args) {
        EncodeDecode encodeDecode=new EncodeDecode();
        List<String> list=new ArrayList<>();
        list.add("");
        String encoded=encodeDecode.encode(list);
        System.out.println(encodeDecode.decode(encoded));
    }
    public String encode(List<String> strs) {
        StringBuilder builder=new StringBuilder();
        for (String str : strs) {
            builder.append(str.length()).append('#').append(str);
        }
        return builder.toString();
    }

    public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();
        int i=0,n= str.length();
        while (i<n){
            int j=i;
            while (str.charAt(j)!='#'){
                j++;
            }
            int length=Integer.parseInt(str.substring(i,j));
            i=j+1;
            j=i+length;
            ans.add(str.substring(i,j));
            i=j;
        }
        return ans;
    }
}
