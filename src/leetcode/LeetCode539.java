package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode539 {

    public static void main(String[] args) {
        List<String> problems = new ArrayList<>();
        problems.add("23:59");
        problems.add("00:00");
        List<String> problems2 = new ArrayList<>();
        problems2.add("00:00");
        problems2.add("04:00");
        problems2.add("22:00");
//        System.out.println(new LeetCode539().findMinDifference(problems));
        System.out.println(new LeetCode539().findMinDifference(problems2));
    }

    private final int DEFAULT_TIME = 720;

    public int findMinDifference(List<String> timePoints) {

        timePoints.sort(String::compareTo);

        int answer = timeCalculator(timePoints.get(0).split(":"), timePoints.get(timePoints.size() - 1).split(":"));
        for (int i = 0; i < timePoints.size() - 1; i++) {

            int result = timeCalculator(timePoints.get(i).split(":"), timePoints.get(i + 1).split(":"));

            if (result == 0) {
                return 0;
            }

            if (result < answer) {
                answer = result;
            }

        }
        return answer;
    }

    private int timeCalculator(String[] firstTime, String[] secondTime) {

        int firstHour = toInt(firstTime[0]);
        int secondHour = toInt(secondTime[0]);

        int result = (secondHour * 60) + toInt(secondTime[1]) - (firstHour * 60) - toInt(firstTime[1]);

        if (result > DEFAULT_TIME) {
            return 1440 - result;
        }

        return result;
    }

    private int toInt(String s) {
        return Integer.parseInt(s);
    }

}
