package src.main.kotlin.leetcode.top150;

public class GasStation {
    public static void main(String[] args) {
        System.out.println(canCompleteCircuit(new int[]{2, 0, 1, 2, 3, 4, 0}, new int[]{0, 1, 0, 0, 0, 0, 11}));
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;
        int current = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            total += (gas[i] - cost[i]);
            current += (gas[i] - cost[i]);
            if (current < 0) {
                start = i + 1;
                current=0;
            }
        }
        if (total>=0){
            return start;
        }else {
            return -1;
        }
    }
}
