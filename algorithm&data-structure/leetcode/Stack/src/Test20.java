import java.util.Stack;

/**
 * 有效的括号
 * @author Qin Kai
 * @date 2019-10-26
 */
class Test20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char p = stack.peek();
                if ((c == ')' && p != '(') || (c == '}' && p != '{') || (c == ']' && p != '[') ) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        boolean res = new Test20().isValid("[](){}");
        System.out.println(res);
    }
}
