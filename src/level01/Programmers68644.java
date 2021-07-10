package level01;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

/**
 *
 * 두 개 뽑아서 더하기
 *
 */

public class Programmers68644 {

    public int[] solution(int[] numbers) {
        HashSet<Integer> tempSet = new HashSet<>();

        for(int i=0; i<numbers.length; i++) {
            for(int j=0; j< numbers.length; j++) {
                if(i == j) continue;
                tempSet.add(numbers[i] + numbers[j]);
            }
        }

        Iterator<Integer> iterator = tempSet.iterator();
        int[] answer = new int[tempSet.size()];

        int count = 0;

        while (iterator.hasNext()) {
            answer[count] = iterator.next();
            count++;
        }

        Arrays.sort(answer);

        return answer;
    }

}
