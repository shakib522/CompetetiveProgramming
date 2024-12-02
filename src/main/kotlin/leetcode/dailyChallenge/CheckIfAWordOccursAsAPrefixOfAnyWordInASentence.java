package src.main.kotlin.leetcode.dailyChallenge;

public class CheckIfAWordOccursAsAPrefixOfAnyWordInASentence {
    public static void main(String[] args) {
        System.out.println(isPrefixOfWord("this problem is an easy problem", "pro"));
    }

    public static int isPrefixOfWord(String sentence, String searchWord) {
        boolean active = true;
        int search = 0;
        int index = 0;
        int searchSize = searchWord.length();
        for (int i = 0; i < sentence.length(); i++) {
            if (active) {
                if (sentence.charAt(i) != searchWord.charAt(search)) {
                    search = 0;
                    active = false;
                } else {
                    search++;
                }
            }
            if (searchSize == search) {
                return index + 1;
            }
            if (sentence.charAt(i) == ' ') {
                index++;
                active = true;
                search = 0;
            }
        }
        return -1;
    }

    public int isPrefixOfWord2(String sentence, String searchWord) {
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (words[i].startsWith(searchWord)) {
                return i + 1;
            }
        }
        return -1;
    }
}

//System.out.println("active: "+active);
//            System.out.println("i: "+i);
//            System.out.println("sentence(i): "+sentence.charAt(i));
//        System.out.println("searchSize: "+searchSize);
//            System.out.println("search : "+search);