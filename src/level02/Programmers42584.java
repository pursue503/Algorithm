package level02;


/**
 *
 * 주식 가격
 *
 */

public class Programmers42584 {

    public int[] solution(int[] prices) {
        int [] answer = new int[prices.length];

        for(int i=0 ;i<prices.length; i++) {
            int count = 0;
            int n = prices[i];
            for(int j=i + 1; j<prices.length; j++) {
                if(prices[j] >= n) {
                    count++;
                } else {
                    count++;
                    break;
                }
            }
            answer[i] = count;
        }

        return answer;
    }

}
