package leetcode;

/**
 *
 * Complement of Base 10 Integer
 * https://leetcode.com/problems/complement-of-base-10-integer/
 */

public class LeetCode1009 {

    public static void main(String[] args) {
        System.out.println(new LeetCode1009().bitwiseComplement(10));
    }

    public int bitwiseComplement(int n) {
        return Integer.parseInt(toReversBinary(toBinary(n)), 2);
    }

    public String toBinary(int number) {
        return Integer.toBinaryString(number);
    }

    public String toReversBinary(String binary) {
        StringBuilder builder = new StringBuilder();
        binary.chars().map(num -> num == '1' ? 0 : 1).boxed().forEach(builder::append);
        return builder.toString();
    }


}
