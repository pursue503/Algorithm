package level03;

public class Programmers42579 {

    public int[] solution(String[] genres, int[] plays) {

        Set<String> genresSet = new HashSet<>(Arrays.asList(genres));

        Map<String, Integer> totalMap = new HashMap<>();

        for(String s : genresSet) {
            for(int i=0; i<genres.length; i++) {
                if(s.equals(genres[i])) {
                    try {
                        totalMap.put(s,totalMap.get(s) + plays[i]);
                    } catch (NullPointerException e) {
                        totalMap.put(s, plays[i]);
                    }
                }
            }
        }

        List<Map.Entry<String, Integer>> sortList = new ArrayList<>(totalMap.entrySet());

        // 비교함수 Comparator를 사용하여 오름차순으로 정렬
        Collections.sort(sortList, new Comparator<Map.Entry<String, Integer>>() {
            // compare로 값을 비교
            public int compare(Map.Entry<String, Integer> obj1, Map.Entry<String, Integer> obj2) {
                // 오름 차순 정렬
                return obj1.getValue().compareTo(obj2.getValue());
            }
        });

        Integer[] arr = new Integer[2];
        ArrayList<Integer> answerList = new ArrayList<>();

        for(int i=sortList.size() -1; i>=0; i--) {
            Map.Entry<String, Integer> map = sortList.get(i);
            for(int j=0; j<genres.length; j++) {
                if(map.getKey().equals(genres[j])) {
                    for(int k=0; k<arr.length; k++) {
                        try {
                            if(plays[j] > plays[arr[k]]) {
                                if(k == 0) {
                                    try {
                                        if(plays[arr[0]] > plays[arr[1]]) {
                                            arr[1] = arr[0];
                                        }
                                    } catch (NullPointerException e) {
                                        arr[1] = arr[0];
                                    }

                                }
                                arr[k] = j;
                                break;
                            }
                        } catch (NullPointerException e) {
                            arr[k] = j;
                            break;
                        }

                    }

                }

            }
            answerList.add(arr[0]);
            if(arr[1] != null) answerList.add(arr[1]);
            arr = new Integer[2];
        }

        int[] answer = new int[answerList.size()];
        for(int i=0; i<answer.length; i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }

}
