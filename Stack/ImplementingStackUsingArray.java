package Stack;

import java.util.Arrays;
import java.util.List;

public class ImplementingStackUsingArray {

    private int[] stackArray;

    private int capacity;

    private int topIndex;

    public ImplementingStackUsingArray(int size) {
        this.capacity = size;
        this.stackArray = new int[capacity];
        this.topIndex = -1;
    }

    public ImplementingStackUsingArray() {
        this(1000);
    }

    public void push(int x) {
        if (topIndex >= capacity) {
            System.out.println("Stack Overflow..");
            return;
        }

        stackArray[++topIndex] = x;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow..");
            return -1;
        }
        return stackArray[topIndex--];
    }

    public int top() {
        if (isEmpty()) {
            System.out.println("Stack Underflow..");
            return -1;
        }

        return stackArray[topIndex];
    }

    public boolean isEmpty() {
        return topIndex == -1;
    }

    public static void main(String[] args) {

        ImplementingStackUsingArray st = new ImplementingStackUsingArray();

        List<String> commands = Arrays.asList("ArrayStack", "push", "push", "top", "pop", "isEmpty");

        List<List<Integer>> inputs = Arrays.asList(Arrays.asList(), Arrays.asList(5), Arrays.asList(10),
                Arrays.asList(), Arrays.asList(), Arrays.asList());

        for (int i = 0; i < commands.size(); i++) {
            switch (commands.get(i)) {
                case "push":
                    st.push(inputs.get(i).get(0));
                    System.out.print("null ");
                    break;

                case "pop":
                    System.out.print(st.pop() + " ");
                    break;
                case "top":
                    System.out.print(st.top() + " ");
                    break;
                case "isEmpty":
                    System.out.print((st.isEmpty() ? "true" : "false") + " ");
                    break;
                case "ArrayStack":
                    System.out.print("null ");
                    break;
                default:
                    break;
            }
        }

    }
}
