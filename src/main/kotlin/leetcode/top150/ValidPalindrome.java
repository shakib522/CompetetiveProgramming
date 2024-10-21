package src.main.kotlin.leetcode.top150;

public class ValidPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome2("a"));
    }

    public static boolean isPalindrome(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        s = s.toLowerCase();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z' || (s.charAt(i) >= '0' && s.charAt(i) <= '9')) {
                stringBuilder.append(s.charAt(i));
            }
        }
        StringBuilder main = new StringBuilder(stringBuilder);
        StringBuilder reverse = stringBuilder.reverse();
        if (main.compareTo(reverse) == 0) {
            return true;
        }
        return false;
    }

    public static boolean isPalindrome2(String s) {
        int start = 0;
        int end = s.length() - 1;
        s = s.toLowerCase();
        while (start <= end) {
            if (isValid(s.charAt(start)) && isValid(s.charAt(end))) {
                if (s.charAt(start) != s.charAt(end)) {
                    return false;
                }
                start++;
                end--;
            }else{
                if (!isValid(s.charAt(start))) {
                    start++;
                }
                if (!isValid(s.charAt(end))) {
                    end--;
                }
            }

        }
        return true;
    }

    public static boolean isValid(char s) {
        if ((s >= 'a' && s <= 'z') || (s >= '0' && s <= '9')) {
            return true;
        } else {
            return false;
        }
    }


}
