public class charStack extends AbstractStack<Character> {
    public charStack() {
        super();
    }
    @Override
    public void push(Character item) {
        stack.push(item);
    }
    @Override
    public Character pop() {
        return stack.pop();
    }
    @Override
    public Character peek() {
        return stack.peek();
    }
    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }
    
}
