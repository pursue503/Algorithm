package programmers.level01;

import java.util.HashMap;
import java.util.Map;

public class Programmers178871 {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];

        Map<String, Integer> playerMap = new HashMap<>();
        Map<Integer, String> rankMap = new HashMap<>();

        for (int i=0; i<players.length; i++) {
            playerMap.put(players[i], i + 1);
            rankMap.put(i + 1, players[i]);
        }

        for (String calling : callings) {
            // 해설진이 부른 플레이어 이름
            int rank = playerMap.get(calling);
            // 해설진이 부른 사람의 다음 순위 사람 이름
            String playerName = rankMap.get(rank - 1);

            // 이름 기준 등수 변경
            playerMap.put(calling, rank - 1);
            playerMap.put(playerName, rank);

            // 등수 기준 이름 변경
            rankMap.put(rank - 1, calling);
            rankMap.put(rank, playerName);
        }

        for (Map.Entry<String, Integer> entry : playerMap.entrySet()) {
            answer[entry.getValue() -1] = entry.getKey();
        }

        return answer;
    }

}
