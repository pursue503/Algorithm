package leetcode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Leetcode386 {

    public List<Integer> lexicalOrder(int n) {
        return IntStream.range(1, n + 1).mapToObj(String::valueOf).sorted().mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
    }

}
