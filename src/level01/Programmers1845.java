package level01;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * 프로그래머스 레벨1 폰켓몬
 *
 */

public class Programmers1845 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{3,1,2,3}));
    }

    public static int solution(int[] nums) {

        Set<Integer> set = new HashSet<>();

        for(int i=0; i<nums.length; i++) {
            set.add(nums[i]);
        }

        if(set.size() > nums.length / 2) { // 어차피 nums /2 밖에 못가져감
            return nums.length / 2;
        } else { // 만약에 가져갈수있는것보다 작을경우 전부 가져갈수있음
            return set.size();
        }

    }

    // 람다
    public static int solution2(int[] nums) { // 같은 종류는 안된다, 중복제거하고 카운트가
        return Arrays.stream(nums).distinct().count() > nums.length / 2 ? nums.length / 2 : (int) Arrays.stream(nums).distinct().count();
    }

}
