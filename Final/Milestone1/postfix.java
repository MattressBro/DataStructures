package module4;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;
public class postfix {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\onesh\\OneDrive\\Documents\\GitHub\\DataStructures\\Module4\\module4\\postFix.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println("Postfix expression: " + line);
                System.out.print("Postfix expression result: ");
                parsePostfix(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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