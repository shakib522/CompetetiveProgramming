package src.main.kotlin.leetcode.dailyChallenge;

import java.util.*;

public class ConstructStringWithRepeatLimit {
    public static void main(String[] args) {
        ConstructStringWithRepeatLimit c=new ConstructStringWithRepeatLimit();
        System.out.println(c.repeatLimitedString("xyutfpopdynbadwtvmxiemmusevduloxwvpkjioizvanetecnuqbqqdtrwrkgt",1));
    }
    public String repeatLimitedString(String s,int repeatLimit){
        Map<Character,Integer> mp = new TreeMap<>(Collections.reverseOrder());
        for (int i = 0; i < s.length(); i++) {
            mp.put(s.charAt(i),mp.getOrDefault(s.charAt(i),0)+1);
        }
        List<Map.Entry<Character,Integer>> list = new ArrayList<>(mp.entrySet());
        StringBuilder builder=new StringBuilder();
        System.out.println(list);
        for (int i = 0; i < list.size(); i++) {
            int loop=0;
            char ch=list.get(i).getKey();
            int frequency=list.get(i).getValue();
            while (loop<Math.min(repeatLimit,frequency)){
                builder.append(ch);
                loop++;
            }
            if (repeatLimit<frequency){
                list.get(i).setValue(frequency-repeatLimit);
                if (i<list.size()-1&&list.get(i+1).getValue()==0){
                    list.remove(i+1);
                }
                if (i<list.size()-1){
                    builder.append(list.get(i+1).getKey());
                    list.get(i+1).setValue(list.get(i+1).getValue()-1);
                    i--;
                }
            }else{
                list.get(i).setValue(0);
            }
        }
        return builder.toString();
    }
}