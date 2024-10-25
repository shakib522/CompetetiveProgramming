package src.main.kotlin.leetcode.top150;

import java.util.*;

public class GasStation {
    public static void main(String[] args) {
        System.out.println(canCompleteCircuit(new int[]{2,0,1,2,3,4,0}, new int[]{0,1,0,0,0,0,11}));
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i,gas[i]);
        }
        List<Map.Entry<Integer,Integer>> list = new ArrayList<>(map.entrySet());
        Comparator<Map.Entry<Integer,Integer>> cmp = new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue()-o1.getValue();
            }
        };
        list.sort(cmp);
        Map<Integer,Integer> map2=new LinkedHashMap<>();
        for (Map.Entry<Integer,Integer> pair : list){
            map2.put(pair.getKey(),pair.getValue());
        }
        for (Integer num : map2.keySet()) {
            int index = num;
            int start = 0;
            boolean flag=true;
            for (int i = 0; i < n; i++) {
                start+=gas[index];
                start = start-cost[index];
                if (start>=0){
                    index=(index+1)%n;
                }else{
                    flag=false;
                    break;
                }
            }
            if (flag){
                return index;
            }
        }
        return -1;
    }
}
