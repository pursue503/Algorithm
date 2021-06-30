package level01;

import java.util.Arrays;

public class Programmers17681 {

    public static void main(String[] args) {

//        System.out.println(Arrays.toString(solution(5,new int[]{9, 20, 28, 18, 11}, new int[]{30, 1, 21, 17, 28} )));
//        System.out.println(Arrays.toString(solution2(5, new int[]{9, 20, 28, 18, 11}, new int[]{30, 1, 21, 17, 28})));
//        System.out.println(Arrays.toString(solution2(6,new int[]{46, 33, 33 ,22, 31, 50}, new int[]{27 ,56, 19, 14, 14, 10} )));
        System.out.println(Arrays.toString(solution3(5, new int[]{9, 20, 28, 18, 11}, new int[]{30, 1, 21, 17, 28})));
//        System.out.println(solution3(5, new int[]{9, 20, 28, 18, 11}, new int[]{30, 1, 21, 17, 28}));


    }

    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {

            StringBuilder firstBuilder = new StringBuilder();
            StringBuilder secondBuilder = new StringBuilder();

            while (arr1[i] > 0) {
                firstBuilder.insert(0, arr1[i] % 2);
                arr1[i] = arr1[i] / 2;
            }

            while (arr2[i] > 0) {
                secondBuilder.insert(0, arr2[i] % 2);
                arr2[i] = arr2[i] / 2;
            }

            if (firstBuilder.length() < n) {
                int range = n - firstBuilder.length();
                for (int j = 0; j < range; j++) {
                    firstBuilder.insert(0, "0");
                }
            }

            if (secondBuilder.length() < n) {
                int range = n - secondBuilder.length();

                for (int j = 0; j < range; j++) {
                    secondBuilder.insert(0, "0");
                }
            }

            StringBuilder result = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (String.valueOf(firstBuilder.charAt(j)).equals("1") || String.valueOf(secondBuilder.charAt(j)).equals("1")) {
                    result.append("#");
                } else {
                    result.append(" ");
                }
            }

            answer[i] = result.toString();

        }

        return answer;
    }

    public static String[] solution2(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < n; j++) {

                if (arr1[i] % 2 == 1 || arr2[i] % 2 == 1) {
                    builder.insert(0, "#");
                } else {
                    builder.insert(0, " ");

                }
                arr1[i] /= 2;
                arr2[i] /= 2;
            }
            answer[i] = builder.toString();
        }


        return answer;
    }


}
