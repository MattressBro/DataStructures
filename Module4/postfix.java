import java.util.Stack;
public class postfix {
    public static void main(String[] args) {
        String expression = "42*3+";
        System.out.println("Postfix expression: " + expression);
        System.out.print("Postfix expression result: ");
        parsePostfix(expression);
        String expression2 = "53+7*";
        System.out.println("Postfix expression: " + expression2);
        System.out.print("Postfix expression result: ");
        parsePostfix(expression2);
        String expression3 = "42*+"; // Missing operand
        System.out.println("Postfix expression: " + expression3);
        System.out.print("Postfix expression result: ");
        parsePostfix(expression3);
        
    }
    public static void parsePostfix(String expression){
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (Character.isDigit(c)) {
                stack.push(c - '0');
            } else {
                if(stack.size() < 2){
                    System.out.println("Error: Missing operand\n");
                    return;
                }
                int a = stack.pop();
                int b = stack.pop();
                switch (c) {
                    case '+' -> stack.push(a + b);
                    case '-' -> stack.push(a - b);
                    case '*' -> stack.push(a * b);
                    case '/' -> stack.push(a / b);
                    case '%' -> stack.push(a % b);
                    default -> {
                        System.out.print("Error: Invalid operator\n");
                        return;
                    }
                }
            }
        }
        System.out.print(stack.pop()+"\n");
    }
}