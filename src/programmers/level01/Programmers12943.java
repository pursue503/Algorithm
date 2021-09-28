package level01;

/**
 *
 * 콜라츠 추측
 *
 */
public class Programmers12943 {

    public int solution(int num) {
        long numL = num;
        for(int i=0; i<500; i++) {
            if(numL == 1) return i;

            if(numL % 2 == 0) {
                numL = numL / 2;
            }else {
                numL = numL * 3 + 1;
            }
        }

        return -1;
    }

}
