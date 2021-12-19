package programmers.level03;

import java.util.*;

public class Programmers43164 {

    public static void main(String[] args) {
//        Arrays.stream(new Programmers43164().solution(new String[][]{
//                {"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}
//        })).forEach(item -> System.out.print(item + " "));
//
//        System.out.println();
//
//        Arrays.stream(new Programmers43164().solution(new String[][]{
//                {"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}
//        })).forEach(item -> System.out.print(item + " "));
//
//        System.out.println();

        Arrays.stream(new Programmers43164().solution(new String[][]{
                {"ICN","A"},{"A","B"},{"A","C"},{"C","A"},{"B","D"}
        })).forEach(item -> System.out.print(item + " "));
        //ans : ICN, A, C, A, B, D
    }

    private Map<String, ArrayList<String>> graph;
    private Map<String, boolean[]> visited = new HashMap<>();

    ArrayList<String> answerList = new ArrayList<>();



    public String[] solution(String[][] tickets) {


        //전처리 시작
        graph = new LinkedHashMap<>();

        for (int i=0; i<tickets.length; i++) {

            String key = tickets[i][0];
            String value = tickets[i][1];

            if (graph.containsKey(key)) {
                graph.get(key).add(value);
            } else {

                ArrayList<String> list = new ArrayList<>();
                list.add(value);

                graph.put(key, list);


            }
        }

        for(Map.Entry<String, ArrayList<String>> entry : graph.entrySet()) {
            entry.getValue().sort(String::compareTo);
            visited.put(entry.getKey(), new boolean[entry.getValue().size()]);
        }

        return null;
    }

    private String dfs(String node) {

        return null;
    }


}

