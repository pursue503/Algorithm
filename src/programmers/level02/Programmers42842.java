package programmers.level02;

import java.util.LinkedList;

/**
 *
 * Level2 카펫
 *
 */

public class Programmers42842 {

    public static void main(String[] args) {

    }

    public int[] solution(int brown, int yellow) {

        LinkedList<Integer> list = new LinkedList<>();

        int max = brown + yellow;
        for(int i=1; i<= max; i++) {
            if(max % i == 0) {
                list.add(i);
            }
        }

        return list.size() % 2 == 1 ?
                new int[]{list.get(list.size() / 2), list.get(list.size() / 2)} : new int[]{list.get(list.size() / 2), list.get((list.size() /2) - 1)};
    }

}
