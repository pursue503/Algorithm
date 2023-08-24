package programmers.level01;

import java.util.LinkedList;

public class Programmers133502 {

    public int solution(int[] ingredients) {

        int answer = 0;

        LinkedList<Integer> queue = new LinkedList<>();


        for (int i = 0; i < ingredients.length; i++) {
            queue.add(ingredients[i]);

            if (queue.size() >= 4) {
                if (queue.get(queue.size() - 1) == 1 && queue.get(queue.size() - 2) == 3 && queue.get(queue.size() - 3) == 2 && queue.get(queue.size() - 4) == 1) {
                    answer++;
                    queue.remove(queue.size() - 1);
                    queue.remove(queue.size() - 1);
                    queue.remove(queue.size() - 1);
                    queue.remove(queue.size() - 1);
                }
            }
        }

        return answer;
    }

}
