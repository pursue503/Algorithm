package level01;

import java.util.Arrays;

/**
 *
 * 완주하지 못한 선수
 *
 */
public class Programmers42576 {

    public String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);

        for(int i=0; i<completion.length; i++) {
            if(!completion[i].equals(participant[i])) {
                return participant[i];
            }
        }
        return participant[participant.length -1];
    }

}
