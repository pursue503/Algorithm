package level02;

import java.util.Stack;

/**
 *
 * 올바른 괄호
 *
 */

public class Programmers12909 {

    public boolean solution(String s) {

        Stack<Character> stack = new Stack<>();

        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);

            if(c == 40) {
                stack.add(c);
            }

            if(c == 41 && stack.isEmpty()) {
                return false;
            } else if(c == 41) {
                stack.pop();
            }

        }

        return stack.isEmpty();
    }

    public boolean solution2(String s) {
        int count = 0;
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(c == 40) {
                count++;
            }

            if(c == 41) {
                count--;
            }

            if(count < 0) {
                return false;
            }
        }
        return count == 0;
    }

}
