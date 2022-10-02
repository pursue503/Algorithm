package programmers.level0;

import java.util.Map;

public class Programmers120818 {

    public int solution(int price) {
        return price >= 500_000 ? (int) (price * 0.8) : price >= 300_000 ? (int) (price * 0.9) : price >= 100_000 ? (int) (price * 0.95) : price;
    }

    public int solution2(int price) {
        return getDisCountPrice(price);
    }
    public int getDisCountPrice(int price) {
        if (price >= 500_000) {
            return (int) (price * 0.8);
        } else if (price >= 300_000) {
            return (int) (price * 0.9);

        } else if (price >= 100_000) {
            return (int) (price * 0.95);
        }
        return price;
    }

}
