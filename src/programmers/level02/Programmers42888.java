package programmers.level02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Programmers42888 {

    Map<String, String> userInfo = new HashMap<>();

    public String[] solution(String[] record) {


        List<String> messageList = new ArrayList<>();

        for(int i=0; i<record.length; i++) {

            String[] actionInfo = record[i].split(" ");

            if(actionInfo[0].equals("Enter")) {
                messageList.add(actionInfo[1] + action(actionInfo[0]));
            } else if(actionInfo[0].equals("Leave")) {
                messageList.add(actionInfo[1] + action(actionInfo[0]));
                continue;
            }

            insertUserInfo(actionInfo[1], actionInfo[2]);
        }

        String[] answer = new String[messageList.size()];
        int index = 0;
        for(String message : messageList) {

            String[] actionInfo = message.split(" ");

            actionInfo[0] = userInfo.get(actionInfo[0]);

            answer[index] = actionInfo[0] + actionInfo[1] + " " + actionInfo[2];
            index++;
        }
        return answer;
    }

    private String action(String action) {
        return action.equals("Enter") ? " 님이 들어왔습니다." : " 님이 나갔습니다.";
    }

    private void insertUserInfo(String userId, String nickName) {
        userInfo.put(userId, nickName);
    }



}