import java.util.Stack;

class Calculate {
    public int evalRPN(String[] tokens) {
        // 借助栈实现逆波兰式
        Stack<Integer> stack = new Stack<Integer>();

        for (String token : tokens) {
            if ("+" . equals(token)) {
                int num2 = stack.pop();
                int num1 = stack.pop();
                stack.push(num1 + num2);


            } else if (token.equals("-")) {
                int num2 = stack.pop();
                int num1 = stack.pop();
                stack.push(num1 - num2);

            } else if (token.equals("*")) {
                int num2 = stack.pop();
                int num1 = stack.pop();
                stack.push(num1 * num2);

            } else if (token.equals("/")) {
                int num2 = stack.pop();
                int num1 = stack.pop();
                stack.push(num1 / num2);

            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }
}

public class EvaluateReversePolish {
    public static void main(String[] args) {
        Calculate calculate = new Calculate();

        String[] tokens = new String[] {"2", "1", "+", "3", "*"};

        System.out.println("逆波兰式求值为：" + calculate.evalRPN(tokens));
    }
}
