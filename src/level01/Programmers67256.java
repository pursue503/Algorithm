package level01;

/**
 * 
 * 프로그래머스 레벨1 키패드
 * 
 */
public class Programmers67256 {

    public static void main(String[] args) {

        Programmers67256 programmers67256 = new Programmers67256();
        System.out.println(programmers67256.solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right"));
    }

    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();

        int left = 42;
        int right = 35;

        for(int i=0; i<numbers.length; i++) {
            int a = numbers[i];
            if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7 || left == numbers[i]) {
                left = numbers[i];
                answer.append("L");
            } else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9 || right == numbers[i]) {
                right = numbers[i];
                answer.append("R");
            } else {
                if(distance(left,right,numbers[i], hand)) {
                    right = numbers[i];
                    answer.append("R");
                } else {
                    left = numbers[i];
                    answer.append("L");
                }
            }
        }
        return answer.toString();

    }

    private boolean distance (int left, int right, int num , String hand) { // right 가까우면 ture // left 가 가까우면 false

        int[] leftDistance = new int[2];
        int[] rightDistance = new int[2];
        int[] numArr = new int[2];

        int[][] key = new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9},
                {42,0,35}
        };

        for(int i=0; i<key.length; i++) {
            for(int j=0; j<key[j].length; j++) {
                if(left == key[i][j]) {
                    leftDistance[0] = i;
                    leftDistance[1] = j;
                }
                if(right == key[i][j]) {
                    rightDistance[0] = i;
                    rightDistance[1] = j;
                }
                if(num == key[i][j]) {
                    numArr[0] = i;
                    numArr[1] = j;
                }
            }
        }
        int leftNum = Math.abs(numArr[0] - leftDistance[0]) + Math.abs(numArr[1] - leftDistance[1]);
        int rightNum = Math.abs(numArr[0] - rightDistance[0]) + Math.abs(numArr[1] - rightDistance[1]);
        if(leftNum == rightNum) {
            if(hand.equals("right")) {
                return true;
            } else {
                return false;
            }
        }
        return rightNum < leftNum;
    }

}
