package level01;


import java.util.ArrayList;

/**
 *
 * 다트게임
 *
 */
public class Programmers17682 {

    public static void main(String[] args) {
        Programmers17682 programmers17682 = new Programmers17682();

        System.out.println(programmers17682.solution("1D2S#10S"));
    }

    public int solution(String dartResult) {
        int answer = 0;

        ArrayList<String> list = new ArrayList<>();

        String[] arr = dartResult.split("");


        StringBuilder builder = new StringBuilder();


        int count = 0;
        builder.append(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            try {
                int num = Integer.parseInt(arr[i]);

                if(count == 0) {
                    builder.append(num);
                } else {
                    list.add(builder.toString());
                    builder.delete(0, builder.length());
                    builder.append(num);
                    count = 0;
                }

            } catch (NumberFormatException e) {
                builder.append(arr[i]);
                if (i == arr.length - 1) {
                    list.add(builder.toString());
                }
                count++;
            }

        }

        ArrayList<Integer> integerArrayList = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            String[] tempArr = list.get(i).split("");
            int num = pow(tempArr);

            int c = 2;
            if(tempArr[0].equals("1") && tempArr[1].equals("0")) {
                c = 3;
            }
            for(int j=c; j<tempArr.length; j++) {
                if(tempArr[j].equals("*")) {
                    if(i == 0) {
                        num *= 2;
                    } else {
                        num *= 2;
                        integerArrayList.set(i -1, integerArrayList.get(i -1) * 2);
                    }
                } else {
                    num *= -1;
                }
            }

            integerArrayList.add(num);


        }


        for(Integer i : integerArrayList) {
            answer += i;
        }

        return answer;
    }

    private int pow(String[] arr) {
        if(arr[0].equals("1") && arr[1].equals("0")) {
            switch (arr[2]) {

                case "S" :
                    return (int) Math.pow(10, 1);
                case "D":
                    return (int) Math.pow(10, 2);

                case "T":
                    return (int) Math.pow(10, 3);


            }
        } else {
            switch (arr[1]) {

                case "S" :
                    return (int) Math.pow(Integer.parseInt(arr[0]), 1);
                case "D":
                    return (int) Math.pow(Integer.parseInt(arr[0]), 2);

                case "T":
                    return (int) Math.pow(Integer.parseInt(arr[0]), 3);


            }
        }

        return 0;
    }

}
