package level01;

import java.util.Arrays;

public class Programmers17681 {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(solution(5,new int[]{9, 20, 28, 18, 11}, new int[]{30, 1, 21, 17, 28} )));

    }

    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];


        for(int i=0; i<n; i++) {

            StringBuilder firstBuilder = new StringBuilder();
            StringBuilder secondBuilder = new StringBuilder();

            while (arr1[i] > 0) {
                firstBuilder.append(arr1[i] % 2);
                arr1[i] = arr1[i] / 2;
            }

            while (arr2[i] > 0) {
                secondBuilder.append(arr2[i] % 2);
                arr2[i] = arr2[i] / 2;
            }

            firstBuilder.reverse();
            secondBuilder.reverse();
            if(firstBuilder.length() < n)  {
                int range = n-firstBuilder.length();
                for(int j=0; j<range; j++) {
                    firstBuilder.insert(0, "0");
                }
            }

            if(secondBuilder.length() < n)  {
                int range = n-secondBuilder.length();

                for(int j=0; j<range; j++) {
                    secondBuilder.insert(0, "0");
                }
            }

            StringBuilder result = new StringBuilder();
            for(int j=0; j<n; j++) {
                if(String.valueOf(firstBuilder.charAt(j)).equals("1") || String.valueOf(secondBuilder.charAt(j)).equals("1")) {
                    result.append("#");
                } else {
                    result.append(" ");
                }
            }

            answer[i] = result.toString();

        }

        return answer;
    }

}
