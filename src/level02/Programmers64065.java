package level02;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * 튜플
 *
 */
public class Programmers64065 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("{{2},{2,1},{2,1,3},{2,1,3,4}}")));
    }

    public static int[] solution(String s) {

        Map<Integer, Integer> map = new HashMap<>();

        StringBuilder builder = new StringBuilder(s);

        builder.deleteCharAt(0);
        builder.deleteCharAt(builder.length() -1);

        String[] arr = builder.toString().split(",");

        for(String str : arr) {
            String[] temp =  str.replace("{", "").replace("}","").split(",");

            for(String tempStr : temp) {

                int key = Integer.parseInt(tempStr);

                if(map.containsKey(key)) {
                    map.put(key , map.get(key) + 1);
                    continue;
                }

                map.put(key , 1);
            }
        }

        ArrayList<Map.Entry<Integer, Integer>> sortList = new ArrayList<>(map.entrySet());

        sortList.sort(((o1, o2) -> o2.getValue().compareTo(o1.getValue())));

        int[] answer = new int[sortList.size()];

        int index = 0;
        for(Map.Entry<Integer, Integer> entry : sortList) {
            answer[index] = entry.getKey();
            index++;
        }

        return answer;

    }

}
