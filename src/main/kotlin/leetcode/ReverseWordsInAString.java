package src.main.kotlin.leetcode;

public class ReverseWordsInAString {
    public String reverseWords(String s) {
        String[] str=s.trim().split("\\s+");
        int first=0;
        int last=str.length-1;
        while (first<last){
            String temp=str[first];
            str[first]=str[last];
            str[last]=temp;
            first++;
            last--;
        }
        return String.join(" ",str);
    }
}
