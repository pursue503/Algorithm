package level01;

import java.util.ArrayList;

/**
 *
 * 같은 숫자는 싫어
 *
 */
public class Programmers12906 {

    public int[] solution(int []arr) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        int num = -1;

        for(int i=0; i<arr.length; i++) {
            if(num != arr[i]) {
                arrayList.add(arr[i]);
            }
            num = arr[i];
        }

        int[] answer = new int[arrayList.size()];

        for(int i=0; i< arrayList.size(); i++) {
            answer[i] = arrayList.get(i);
        }

        return answer;
    }

}
