package leetcode.study.day1;

/**
 *
 * Find Pivot Index
 *
 */

public class LeetCode724 {

    public static void main(String[] args) {
        System.out.println(new LeetCode724().pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
    }

    public int pivotIndex(int[] nums) {

        int sum = 0;

        // 모든 값 더하기
        for (int num : nums) {
            sum+= num;
        }

        // 루프 돌면서 저장할 변수
        int loopSum = 0;

        for (int i=0; i<nums.length; i++) {

            // sum 은 전체를 더한거기에 조건 검사전에 i 를 제외시키고 검증하기 위해 먼저 제거 ( 피벗 인덱스 )
            sum -= nums[i];

            if (sum == loopSum) {
                return i;
            }
            loopSum += nums[i];


        }

        return -1;
    }
}
