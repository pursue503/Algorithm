package programmers.level02;

public class Programmers42860 {

    public static void main(String[] args) {
        System.out.println(new Programmers42860().solution("JAZ"));
        System.out.println(new Programmers42860().solution("JEROEN"));
        System.out.println(new Programmers42860().solution("JAN"));
    }

    public int solution(String name) {
        int answer = 0;
        int[] joystick = new int[name.length()];

        int check = 1;

        for (int i = 0; i< joystick.length; i++) {
            int count = Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
            joystick[i] = count;
            answer += count;

            if (count == 0) {
                check++;
            }
        }

        joystick[0] = 0;

        int cursor = 0;
        while (check != name.length()) {

        }

        return answer;
    }

}