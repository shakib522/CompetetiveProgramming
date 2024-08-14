package src.main.kotlin.leetcode.top100.javaSolution;

import java.util.*;

public class PartitionTable {
    public static void main(String[] args) {
        PartitionTable t=new PartitionTable();
        System.out.println(t.partitionLabels("eccbbbbdec"));
    }
    public List<Integer> partitionLabels(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for (int i=0;i<s.length();i++){
            map.put(s.charAt(i),i);
        }
        int first=0;
        int last=0;
        List<Integer> ans = new ArrayList<>();
        for (int i=0;i<s.length();i++){
            if(map.get(s.charAt(i))>last){
                last=map.get(s.charAt(i));
            }
            if (i==last){
                ans.add(last-first+1);
                first=++last;
            }
        }
        return ans;
    }
}
