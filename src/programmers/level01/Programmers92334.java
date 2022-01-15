package programmers.level01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 *
 * 신고 결과 받기
 *
 */

public class Programmers92334 {

    public int[] solution(String[] id_list, String[] report, int k) {

        int[] answer = new int[id_list.length];

        Map<String, List<String>> result = new HashMap<>();
        Map<String, Integer> counting = new HashMap<>();


        for (int i=0; i<id_list.length; i++) {
            result.put(id_list[i], new ArrayList<>());
            counting.put(id_list[i], 0);
        }

        for (String names : report) {

            String[] arr = names.split(" ");

            List<String> userReportLog = result.get(arr[0]);

            if (!userReportLog.contains(arr[1])) {
                userReportLog.add(arr[1]);
                counting.put(arr[1], counting.get(arr[1]) + 1);
            }

        }

        List<String> block = counting.entrySet()
                .stream()
                .filter(entry -> entry.getValue() >= k)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        for (int i=0; i<id_list.length; i++) {

            List<String> userBlocks = result.get(id_list[i]);

            long count = userBlocks.stream()
                    .filter(block::contains)
                    .count();

            answer[i] = (int) count;
        }

        return answer;
    }

}
