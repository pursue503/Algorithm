package programmers.level01;

import java.util.*;
import java.util.stream.Collectors;

public class Programmers150370 {

    public static void main(String[] args) {
//        new Programmers150370().solution("2022.05.19", new String[]{"A 6", "B 12", "C 3"}, new String[]{"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"});
//        System.out.println(Arrays.toString(new Programmers150370().solution("2020.05.17", new String[]{"A 3", "B 12"}, new String[]{"2020.01.01 A", "2020.05.17 B"})));
        System.out.println(Arrays.toString(new Programmers150370().solution("2020.12.17", new String[]{"A 12"}, new String[]{"2010.01.01 A", "2019.12.17 A"})));
    }

    public int[] solution(String stringToday, String[] terms, String[] privacies) {
        List<Integer> list = new ArrayList<>();
        Map<String, Integer> termsMap = Arrays.stream(terms)
                .map(it -> it.split(" "))
                .collect(Collectors.toMap(it -> it[0], it -> Integer.valueOf(it[1])));

        Date today = convertDate(stringToday);

        for (int i = 0; i < privacies.length; i++) {
            if (isDelete(today, termsMap, privacies[i])) {
                list.add(i + 1);
            }
        }

        int[] answer = new int[list.size()];

        for (int i = 0; i< list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }

    private Date convertDate(String stringDate) {
        String[] dateArray =  stringDate.split("\\.");
        return new Date(dateArray[0], dateArray[1], dateArray[2]);
    }

    private boolean isDelete(Date today, Map<String, Integer> termsMap, String privacies) {
        StringBuilder builder = new StringBuilder(privacies);

        String type = String.valueOf(privacies.charAt(privacies.length() - 1));

        builder.delete(builder.length() - 2, builder.length());

        Date privaciesDate = convertDate(builder.toString());

        privaciesDate.plus(termsMap.get(type));

        return privaciesDate.compareTo(today);
    }

    public int[] solution2(String stringToday, String[] terms, String[] privacies) {
        List<Integer> list = new ArrayList<>();
        Map<String, Integer> termsMap = Arrays.stream(terms)
                .map(it -> it.split(" "))
                .collect(Collectors.toMap(it -> it[0], it -> Integer.valueOf(it[1])));

        int today = toIntDate(stringToday, 0);

        for (int i = 0; i < privacies.length; i++) {
            String[] privacyDate = privacies[i].split(" ");
            if (toIntDate(privacyDate[0], termsMap.get(privacyDate[1])) <= today) {
                list.add(i + 1);
            }
        }

        return list.stream()
                .mapToInt(i -> i)
                .toArray();
    }

    private int toIntDate(String date, int plusMonth) {
        String[] arr = date.split("\\.");
        return (Integer.parseInt(arr[0]) * 12 * 28) + (Integer.parseInt(arr[1]) * 28) + Integer. parseInt(arr[2]) + (plusMonth * 28);
    }

}


class Date {
    private int year;
    private int month;
    private int day;

    public Date(String year, String month, String day) {
        this.year = Integer.parseInt(year);
        this.month = Integer.parseInt(month);
        this.day = Integer.parseInt(day);
    }

    public void plus(int addMonth) {
        this.month += addMonth;

        if (month > 12) {
            this.year += this.month / 12;
            this.month = this.month % 12;
        }

        if (month <= 0) {
            month = 12;
            year -= 1;
        }

        day -= 1;

        if (day <= 0) {
            day = 28;
            month -= 1;
            if (month <= 0) {
                month = 12;
                year -= 1;
            }
        }

    }

    public boolean compareTo(Date toDay) {
        if (this.year < toDay.year) {
            return true;
        }

        if (this.year > toDay.year) {
            return false;
        }

        if (this.month < toDay.month) {
            return true;
        }

        if (this.month > toDay.month) {
            return false;
        }

        if (this.day < toDay.day) {
            return true;
        }

        return false;
    }

}