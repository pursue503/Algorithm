package level02;


import java.util.HashMap;
import java.util.Map;

/**
 *
 * 위장
 *
 */

public class Programmers42578 {

    public static void main(String[] args) {

        Programmers42578 programmers42578 = new Programmers42578();

        System.out.println(programmers42578.solution(new String[][]{{"yellowhat", "headgear"},{"bluesunglasses", "eyewear"},{"green_turban", "headgear"}}));

    }

    public int solution(String[][] clothes) {
        Map<String , Integer> resultMap = new HashMap<>();
        // ************* 같은 이름을 가진 의상은 존재하지 않습니다.
        // ************* clothes의 각 행은 [의상의 이름, 의상의 종류]로 이루어져 있습니다.
        for(int i=0; i<clothes.length; i++) {
            if(!resultMap.containsKey(clothes[i][1])) { // 존재하지 않으면 true
                resultMap.put(clothes[i][1],1); //기본 1개추가
            } else { //존재하면
                resultMap.put(clothes[i][1],resultMap.get(clothes[i][1]) +1 ); //현재값 ++
            }
        }

        int answer = 1;
        for(int i : resultMap.values()) {
            answer = answer * (i + 1);
        }


        return answer - 1;
    }

}
