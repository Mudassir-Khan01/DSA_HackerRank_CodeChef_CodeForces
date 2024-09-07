package Question_queue_Stack;

import java.util.Stack;

public class _5AddParenthesis {
    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char ch = charArray[i];
            if (ch == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            } else {//if that is opening bracket then also push
                stack.push(ch);

            }
        }
        return stack.size();
    }

    public static void main(String[] args) {
        _5AddParenthesis obj=new _5AddParenthesis();
        System.out.println(obj.minAddToMakeValid("(()("));
    }
}
                        