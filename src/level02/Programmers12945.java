package level02;

/**
 *
 * 피보나치의 수
 *
 */
public class Programmers12945 {

    public static void main(String[] args) {
        Programmers12945 programmers12945 = new Programmers12945();
        System.out.println(programmers12945.solution(40));
        System.out.println(programmers12945.solution2(40));
    }

    public int solution(int n) {
        return recursive(0,1, n);
    }

    public int recursive(int f1, int f2 , int n ) {

        int f = (f1 +  f2) % 1234567;

        if(n == 2) {
            return f;
        }

        return recursive(f2, f, n -1);
    }

    public int solution2(int n) {
        int[] fArr = new int[n + 1];

        fArr[0] = 0; // F(0) = 0;
        fArr[1] = 1; // F(1) = 1;

        for(int i=2; i<fArr.length; i++) {
            fArr[i] = (fArr[i -1] + fArr[i - 2]) % 1234567;
        }

        return fArr[n];
    }



}
