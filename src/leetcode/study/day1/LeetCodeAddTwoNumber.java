package leetcode.study.day1;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * Add Two Numbers
 *
 */

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}

public class LeetCodeAddTwoNumber {

    public static void main(String[] args) {
//        System.out.println(new LeetCode1().addTwoNumbers(new ListNode(2, new ListNode(4, new ListNode(3))), new ListNode(5, new ListNode(6, new ListNode(4)))));
//        System.out.println(new LeetCode1().addTwoNumbers(new ListNode(2, new ListNode(4, new ListNode(9))), new ListNode(5, new ListNode(6, new ListNode(4, new ListNode(9))))));
        System.out.println(new LeetCodeAddTwoNumber().addTwoNumbers(new ListNode(9), new ListNode(1, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9 , new ListNode( 9, new ListNode(9, new ListNode(9 , new ListNode(9))))))))))));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {


        BigInteger result = toBiginteger(revers(recursive(l1)), revers(recursive(l2)));

        StringBuilder reversBuilder = new StringBuilder(String.valueOf(result));

        reversBuilder.reverse();

        List<ListNode> list = new ArrayList<>();

        for(char c : reversBuilder.toString().toCharArray()) {
            list.add(new ListNode(Integer.parseInt(String.valueOf(c))));
        }
        for(int i=0; i<list.size() - 1; i++) {
            list.get(i).next = list.get(i + 1);
        }

        return list.get(0);
    }

    private BigInteger toBiginteger(String firstNum, String secondNum) {
        return new BigInteger(firstNum).add(new BigInteger(secondNum));
    }

    private String revers(String number) {
        return new StringBuilder(number).reverse().toString();
    }

    public String recursive(ListNode listNode) {
        if(listNode.next == null) {
            return String.valueOf(listNode.val);
        }
        return listNode.val + recursive(listNode.next);
    }

}
