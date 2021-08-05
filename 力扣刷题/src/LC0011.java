import java.util.Stack;

/**
 * 20. 有效的括号
 *      给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *      有效字符串需满足：
 *      左括号必须用相同类型的右括号闭合。
 *      左括号必须以正确的顺序闭合。
 *
 */
public class LC0011 {

    public static void main(String[] args) {
        String s = "{[]}";
        System.out.println(isValid(s));
    }
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0;i<s.length();i++){
            if (stack.isEmpty())
                stack.push(s.charAt(i));
            else{
                char c = stack.peek();
                if (c == '(')
                    if (s.charAt(i)==')'){
                        stack.pop();
                    }else
                        stack.push(s.charAt(i));
                else if (c == '{')
                    if (s.charAt(i)=='}'){
                        stack.pop();
                    }else
                        stack.push(s.charAt(i));
                else if (c == '[')
                    if (s.charAt(i)==']'){
                        stack.pop();
                    }else
                        stack.push(s.charAt(i));
            }
        }

        if (!stack.isEmpty())
            return false;
        return true;
    }
}
