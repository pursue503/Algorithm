package leetcode.study.day1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode500 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Leetcode500().findWords(new String[]{"Hello","Alaska","Dad","Peace"})));
    }

    public String[] findWords(String[] words) {

        List<String> answerList = new ArrayList<>();

        List<String> wordList = toList();

        for (String word : words) {

            String item = word.toLowerCase();

            for (String list : wordList) {

                if (list.contains(String.valueOf(item.charAt(0)))) {
                    int length = item.length();

                    long answer = item.chars().filter(str -> list.contains(Character.toString(str))).count();

                    if (length == answer) {
                        answerList.add(word);
                    }

                }

            }
        }

        String[] answer = new String[answerList.size()];

        for (int i=0; i<answer.length; i++) {
            answer[i] = answerList.get(i);
        }

        return answer;

    }

    private List<String> toList() {
        List<String> wordList = new ArrayList<>();

        wordList.add("qwertyuiop");
        wordList.add("asdfghjkl");
        wordList.add("zxcvbnm");

        return wordList;
    }

}
