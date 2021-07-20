package level02;

/**
 *
 * N개의 최소공배수
 *
 */

public class Programmers12953 {

    public static void main(String[] args) {
        Programmers12953 programmers12953 = new Programmers12953();

        System.out.println(programmers12953.solution(new int[]{2, 6, 8, 14}));
        System.out.println(programmers12953.solution(new int[]{1, 2, 3}));
    }

    public int solution(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i + 1] = (arr[i] * arr[i + 1]) / gcd(arr[i], arr[i + 1]);
        }

        return arr[arr.length - 1];
    }

    public int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }


}
