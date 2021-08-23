package level01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * 위클리 4주차
 *
 */

public class Programmers84325 {

    public String solution(String[] table, String[] languages, int[] preference) {

        Map<String, Integer> map = new HashMap<>();

        for(int i=0; i<languages.length; i++) {
            map.put(languages[i], preference[i]);
        }

        Map<String ,Integer> resultMap = new HashMap<>();

        for(int i=0; i<table.length; i++) {
            String[] arr = table[i].split(" ");
            int result = 0;
            for(int j=1; j<arr.length; j++) {
                if(map.containsKey(arr[j])) {
                    result += map.get(arr[j]) * (6 - j);
                }
            }
            resultMap.put(arr[0], result);
        }

        ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(resultMap.entrySet());
        list.sort((o1, o2) -> {

            if(o2.getValue().compareTo(o1.getValue()) == 0) {
                return o1.getKey().compareTo(o2.getKey());
            }
            return o2.getValue().compareTo(o1.getValue());
        });

        return list.get(0).getKey();
    }


}
