package src.main.kotlin.leetcode.dailyChallenge;

public class AddingSpacesToAString {
    public static void main(String[] args) {
        System.out.println(addSpaces2("LeetcodeHelpsMeLearn",new int[]{8,13,15}));
    }
    public static String addSpaces(String s, int[] spaces) {
        StringBuilder builder=new StringBuilder(s);
        for (int i = 0; i < spaces.length; i++) {
            builder.insert(spaces[i]+i,' ');
        }
        return builder.toString();
    }
    public static String addSpaces2(String s, int[] spaces) {
        int i=0,j=0,k=0;
        int len=s.length();
        int spaceLen=spaces.length;
        char[] ch=new char[len+spaceLen];
        while (i<len&&j<spaceLen){
            int temp=spaces[j];
            while (i<temp){
                ch[k++]=s.charAt(i++);
            }
            ch[k++]=' ';
            j++;
        }
        while (i<len){
            ch[k++]=s.charAt(i++);
        }
        return new String(ch);
    }
}
