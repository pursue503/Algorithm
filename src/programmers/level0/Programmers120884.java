package programmers.level0;

public class Programmers120884 {
    public int solution(int chicken) {
        int coupon = chicken;
        int answer = 0;
        while (coupon >= 10) {
            answer += coupon / 10;
            coupon = coupon % 10 + (coupon / 10);
        }
        return answer;
    }
}