package level02;

import java.util.ArrayList;

public class Programmers17680 {

    public static void main(String[] args) {
        System.out.println(new Programmers17680().solution(2, new String[]{"Jeju", "Pangyo", "NewYork", "newyork"}));
    }

    public int solution(int cacheSize, String[] cities) {

        if(cacheSize == 0) {
            return cities.length * 5;
        }

        int answer = 0;

        ArrayList<String> list = new ArrayList<>();

        for(int i=0; i<cities.length; i++) {
            String s = cities[i].toLowerCase();
            if(list.contains(s)) {
                list.remove(s);
                list.add(s);
                answer++;
            } else {
                if(list.size() < cacheSize) {
                    list.add(s);
                    answer += 5;
                } else {
                    list.remove(0);
                    list.add(s);
                    answer+= 5;
                }
            }
        }
        return answer;
    }

}
