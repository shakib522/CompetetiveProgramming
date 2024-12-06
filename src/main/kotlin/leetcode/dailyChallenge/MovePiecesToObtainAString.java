package src.main.kotlin.leetcode.dailyChallenge;

public class MovePiecesToObtainAString {
    public static void main(String[] args) {
        System.out.println(canChange("R_L_", "__LR"));
    }

    public static boolean canChange(String start, String target) {
        int i = 0, j = 0, n = start.length();
        while (i < n || j < n) {
            while (i < n && start.charAt(i) == '_') {
                i++;
            }
            while (j < n && start.charAt(j) == '_') {
                j++;
            }
            if (start.charAt(i) != target.charAt(j)) {
                return false;
            }
            if (start.charAt(i) == 'L' && i < j) {
                return false;
            }
            if (start.charAt(i) == 'R' && i > j) {
                return false;
            }
            i++;
            j++;
        }
        return true;
    }
}
