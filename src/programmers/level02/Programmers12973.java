package level02;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 *
 * 짝지어 제거하기
 *
 */

public class Programmers12973 {

    public static void main(String[] args) {
        System.out.println(solution("baabaa"));
        System.out.println(solution2("baabaa"));
        System.out.println(solution3("baabaa"));
        System.out.println(solution4("baabaa"));


    }


    //Stack
    public static int solution(String s) {

        Stack<String> stringStack = new Stack<>();
        for(int i=0; i<s.length(); i++) {

            if(!stringStack.isEmpty()) { // 스택이 비어있지 않으면
                if(stringStack.peek().equals(String.valueOf(s.charAt(i)))) { // 첫 값은 0번쨰 index 값이 들감  0 , 1 비교  -> 0 1 같다면 둘다 삭제해야함 스택에서 0 번만 삭제시켜줌
                    stringStack.pop();
                    continue;
                }
            }

            stringStack.push(String.valueOf(s.charAt(i))); // 값넣어주기

        }

        return stringStack.size() == 0 ? 1 : 0;
    }

    //LinkedList
    public static int solution2(String s) {

        LinkedList<String> stringLinkedList = new LinkedList<>();
        for(int i=0; i<s.length(); i++) {

            if(!stringLinkedList.isEmpty()) {
                if(stringLinkedList.get(stringLinkedList.size() -1).equals(String.valueOf(s.charAt(i)))) {
                    stringLinkedList.remove(stringLinkedList.size() -1);
                    continue;
                }
            }

            stringLinkedList.add(String.valueOf(s.charAt(i)));
        }

        return stringLinkedList.size() == 0 ? 1 : 0;

    }

    //ArrayList
    public static int solution3(String s) {

        ArrayList<String> arrayList = new ArrayList<>();
        for(int i=0; i<s.length(); i++) {

            if(!arrayList.isEmpty()) {
                if(arrayList.get(arrayList.size() -1).equals(String.valueOf(s.charAt(i)))) {
                    arrayList.remove(arrayList.size() -1);
                    continue;
                }
            }

            arrayList.add(String.valueOf(s.charAt(i)));
        }

        return arrayList.size() == 0 ? 1 : 0;

    }

    //builder
    public static int solution4(String s) {

        StringBuilder builder = new StringBuilder();

        for(int i=0; i<s.length(); i++) {

            if(builder.length() != 0) {
                if(builder.charAt(builder.length() -1) == s.charAt(i)) {
                    builder.deleteCharAt(builder.length() -1);
                    continue;
                }
            }

            builder.append(s.charAt(i));

        }

        return builder.length() == 0 ? 1: 0;
    }


}
