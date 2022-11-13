package programmers.level01;

public class Programmers131128 {
    public String solution(String X, String Y) {
        int[] xArr = new int[10];
        int[] yArr = new int[10];

        for (char c : X.toCharArray()) {
            xArr[c - 48]++;
        }

        for (char c : Y.toCharArray()) {
            yArr[c - 48]++;
        }

        StringBuilder answer = new StringBuilder();

        for (int i=9; i>=0; i--) {
            if (xArr[i] > 0 && yArr[i] > 0) {
                answer.append(String.valueOf(i).repeat(Math.min(xArr[i], yArr[i])));
            }
        }
        return answer.toString().startsWith("0") ? "0" : answer.toString().equals("") ? "-1" : answer.toString();
    }
}
