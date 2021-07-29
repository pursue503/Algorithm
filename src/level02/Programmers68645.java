package level02;

/**
 *
 * 삼각 달팽이
 *
 */

public class Programmers68645 {

    public int[] solution(int n) {

        int max = 0;
        for(int i=1; i<=n; i++) {
            max += i;
        }

        int[] save = new int[max + 1];

        int num = 1;
        int length = 1;
        boolean flag = true;
        int row = n;
        int plus = 1;
        boolean change = true;
        while (num <= max) {

            if(plus == row && flag) {
                for(int i=0; i<n; i++) {
                    if(num > max) {
                        break;
                    }
                    if(change) {
                        save[length] = num;
                        num++;
                        if(i != n -1) {
                            length++;
                        }
                    } else {
                        if(save[length] == 0) {
                            save[length] = num;
                            num++;
                            if(save[length + 1] == 0) {
                                length++;
                            }
                        } else {
                            break;
                        }
                    }


                }
                if(change) {
                    change = false;
                }
                row--;
                flag = false;
            } else {
                save[length] = num;
                num++;
            }



            if(flag) {
                length += plus;
                plus++;
            } else {
                length -= plus;
                plus--;
            }
            if(save[length - plus] != 0) {
                flag = true;
            }

        }

        int[] answer = new int[max];
        int index = 0;
        for(int i=0; i<save.length; i++) {
            if(save[i] != 0) {
                answer[index] = save[i];
                index++;
            }
        }

        return answer;
    }

}
