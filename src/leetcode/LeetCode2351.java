package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode2351 {
    public char repeatedCharacter(String s) {
        Map<Character, Character> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                return c;
            }
            map.put(c, c);
        }
        return 0;
    }
}
