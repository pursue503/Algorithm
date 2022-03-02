package leetcode;

public class LeetCode605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        for (int i=0; i<flowerbed.length; i++) {

            if (n == 0) {
                return true;
            }

            if (flowerbed[i] == 1) {
                continue;
            }

            if (flowerbed.length == 1) {
                if (flowerbed[i] == 0) {
                    flowerbed[i] = 1;
                    n--;
                    continue;
                }
            }

            if (i == 0) {

                if (flowerbed[i + 1] == 0) {
                    flowerbed[i] = 1;
                    n--;
                }

            } else if(i == flowerbed.length - 1) {
                if (flowerbed[i  - 1] == 0) {
                    flowerbed[i] = 1;
                    n--;
                }
            } else {
                if (flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
                    flowerbed[i] = 1;
                    n--;
                }
            }

        }

        return n <= 0;
    }
}
