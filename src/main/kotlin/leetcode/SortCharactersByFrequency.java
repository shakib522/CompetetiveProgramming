package src.main.kotlin.leetcode;

import src.main.kotlin.Pair;

import java.util.*;

public class SortCharactersByFrequency {
    public static void main(String[] args) {
        SortCharactersByFrequency s=new SortCharactersByFrequency();
        System.out.println(s.frequencySort("tree"));
    }
    public String frequencySort(String s) {
        List<Pair<Character,Integer>> list = new ArrayList<>();
        Map<Character,Integer> map = new HashMap<>();

        for (int i=0;i<s.length();i++){
            if (map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),map.get(s.charAt(i))+1);
            }else{
                map.put(s.charAt(i),1);
            }
        }
        for (Map.Entry<Character,Integer> element:map.entrySet()){
            list.add(new Pair<>(element.getKey(),element.getValue()));
        }
        Comparator<Pair<Character,Integer>> comparator = new Comparator<>() {
            @Override
            public int compare(Pair<Character, Integer> o1, Pair<Character, Integer> o2) {
                return o2.getSecond()-o1.getSecond();
            }
        };
        list.sort(comparator);
        StringBuilder ans = new StringBuilder();
        for (Pair<Character,Integer> e:list){
            ans.append(String.valueOf(e.getFirst()).repeat(Math.max(0, e.getSecond())));
        }
        return ans.toString();
    }
}