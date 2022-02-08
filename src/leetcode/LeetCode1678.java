package leetcode;

public class LeetCode1678 {
    public String interpret(String command) {
        return command.replace("()", "o")
                .replace("(", "")
                .replace(")", " ")
                .replaceAll(" ", "")
                .trim();
    }
}
