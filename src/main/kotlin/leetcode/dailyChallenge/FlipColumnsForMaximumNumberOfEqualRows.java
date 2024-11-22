package src.main.kotlin.leetcode.dailyChallenge;

import java.util.*;
import java.util.stream.Collectors;

public class FlipColumnsForMaximumNumberOfEqualRows {
    public static void main(String[] args) {
        System.out.println(maxEqualRowsAfterFlips(new int[][]{
                {0,1},
                {1,0}
        }));
    }
    public static int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<String,Integer>mp=new HashMap<>();
        for (int i = 0; i < matrix.length; i++) {
            String s=Arrays.stream(matrix[i]).mapToObj(String::valueOf).collect(Collectors.joining(""));
            if (!mp.containsKey(s)){
                StringBuilder builder=new StringBuilder();
                for (int j = 0; j < matrix[i].length; j++) {
                    builder.append(1^matrix[i][j]);
                }
                if (!mp.containsKey(builder.toString())){
                    mp.put(s,1);
                }else{
                    mp.put(builder.toString(),mp.get(builder.toString())+1);
                }
            }else{
                mp.put(s,mp.get(s)+1);
            }

        }
        return Collections.max(mp.values());
    }
}
