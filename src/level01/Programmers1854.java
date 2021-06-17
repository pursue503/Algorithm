package level01;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * 프로그래머스 레벨1 폰켓몬
 *
 */

public class Programmers1854 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{3,1,2,3}));
    }

    public static int solution(int[] nums) {

        //중복제거

        Set<Integer> numSet = new HashSet<>();

        Arrays.stream(nums).forEach(numSet::add);



        return numSet.size();

    }

}
