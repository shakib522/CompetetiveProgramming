package src.main.kotlin.leetcode.top150;

public class RansomNote {
    public static void main(String[] args) {
        RansomNote ransomNote=new RansomNote();
        ransomNote.canConstruct("","");
    }
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] araRansomNote = new int[27];
        int[] araMagazine = new int[27];
        countWord(ransomNote,araRansomNote);
        countWord(magazine,araMagazine);
        for (int i=0;i<27;i++){
            if (araRansomNote[i]>0 && araRansomNote[i]>araMagazine[i]){
                return false;
            }
        }
        return true;
    }
    public void countWord(String str,int[] ara){
        for (int i=0;i<str.length();i++){
            ara[str.charAt(i)-'a']++;
        }
    }

}
