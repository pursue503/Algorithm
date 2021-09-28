package level01;

import java.util.ArrayList;
import java.util.List;

/**
 * 소수 만들기
 */

public class Programmers12977 {

    public static void main(String[] args) {
//        System.out.println(solution(new int[]{1,2,3,4}));
        System.out.println(solution(new int[]{1, 2, 7, 6, 4}));
    }

    public static int solution(int[] nums) {

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int m = j + 1; m < nums.length; m++) {
                    list.add(nums[i] + nums[j] + nums[m]);
                }
            }
        }

        return (int) list.stream().filter(num -> {

            boolean flag = true;

            int sq = (int) Math.sqrt(num);
            for (int i = 2; i <= sq; i++) {
                if (num % i == 0) {
                    flag = false;
                }
            }
            return flag;
        }).count();
    }

}
