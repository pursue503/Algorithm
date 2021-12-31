package leetcode.study.day1;

import java.util.*;
import java.util.stream.Collectors;

public class Leetcode386 {

    public List<Integer> lexicalOrder(int n) {

        List<String> list = new ArrayList<>();

        for (int i=1; i<=n; i++) {
            list.add(String.valueOf(i));
        }
        list.sort(String::compareTo);

        return list.stream().mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
    }

}
