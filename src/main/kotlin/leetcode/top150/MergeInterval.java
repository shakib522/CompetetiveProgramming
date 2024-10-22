package src.main.kotlin.leetcode.top150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeInterval {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(merge(new int[][]{{1, 3}, {2, 6}, {15, 18}, {8, 10}})));
    }
    public static int[][] merge(int[][] intervals) {
        if (intervals.length==1){
            return intervals;
        }
        List<List<Integer>> ans = new ArrayList<>();
        Comparator<int[]> comparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0],o2[0]);
            }
        };
        int i;
        int n= intervals.length;
        Arrays.sort(intervals,comparator);
        for (i = 0; i < n; i++) {
            if (ans.isEmpty() || intervals[i][0]>ans.get(ans.size()-1).get(1)){
                ans.add(Arrays.asList(intervals[i][0],intervals[i][1]));
            }else{
                ans.get(ans.size()-1).set(1,Math.max(ans.get(ans.size()-1).get(1),intervals[i][1]));
            }
        }
        int[][] res = new int[ans.size()][2];
        for (i = 0; i < ans.size(); i++) {
           res[i][0] = ans.get(i).get(0);
           res[i][1] = ans.get(i).get(1);
        }
        return res;
    }
}