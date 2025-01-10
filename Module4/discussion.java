import java.util.Stack;
public class discussion {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Stack: " + stack);

        System.out.println("Pop: " + stack.pop());
        System.out.println("Stack: " + stack);

        System.out.println("Peek: " + stack.peek());
        System.out.println("Stack: " + stack);

        System.out.println("Search for 2: " + stack.search(2));
        System.out.println("Search for 3: " + stack.search(3));
        System.out.println("Search for 1: " + stack.search(1));
        System.out.println("Search for 4: " + stack.search(4));
    }
}
