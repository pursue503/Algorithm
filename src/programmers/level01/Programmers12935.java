package level01;

import java.util.*;

/**
 * 제일 작은 수 제거하기
 */

public class Programmers12935 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Programmers12935().solution(new int[]{4,3,2,1})));
    }

    public int[] solution(int[] arr) {

        if(arr.length == 1) {
            arr[0] = -1;
            return arr;
        } else {
            List<Integer> list = new ArrayList<>();
            Arrays.stream(arr).forEach(list::add);
            list.remove(list.indexOf(Arrays.stream(arr).min().orElse(-1)));

            int[] result = new int[list.size()];

            for(int i=0; i< result.length; i++) {
                result[i] = list.get(i);
            }

            return result;
        }

    }
}
