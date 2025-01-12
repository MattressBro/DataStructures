import java.util.Stack;

public abstract class AbstractStack<T> {
    public Stack<T> stack;

    public AbstractStack() {
        stack = new Stack<>();
    }

    public abstract void push(T item);
    public abstract T pop();
    public abstract T peek();
    public abstract boolean isEmpty();
}

