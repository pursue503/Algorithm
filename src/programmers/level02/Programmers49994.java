package level02;

public class Programmers49994 {

    public static void main(String[] args) {
        System.out.println(new Programmers49994().solution("UDU"));
    }

    public int solution(String dirs) {
        int answer = 0;
        boolean[][] visited = new boolean[11][11];

        String[] arr = dirs.split("");

        int x = 5;
        int y = 5;

        visited[5][5] = true;
        for(int i=0; i<arr.length; i++) {
            if(y - 1 == -1 || x - 1 == -1 || y + 1 >= visited.length || x + 1 >= visited.length) {
                continue;
            }
            switch (arr[i]) {

                case "U":
                    y--;
                    if(!visited[y][x]) {
                        answer++;
                        visited[y][x] = true;
                    }
                    break;
                case "L" :
                    x--;
                    if(!visited[y][x]) {
                        answer++;
                        visited[y][x] = true;
                    }
                    break;
                case "R":
                    x++;
                    if(!visited[y][x]) {
                        answer++;
                        visited[y][x] = true;
                    }
                    break;
                case "D":
                    y++;
                    if(!visited[y][x]) {
                        answer++;
                        visited[y][x] = true;
                    }
                    break;

            }

        }
        return answer + 1;
    }

}
