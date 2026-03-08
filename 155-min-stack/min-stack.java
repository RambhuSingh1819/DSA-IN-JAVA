class MinStack {
    private Stack<int[]> stk; // each element: {value, currentMin}

    public MinStack() {
        stk = new Stack<>();
    }

    public void push(int val) {
        if (stk.isEmpty()) {
            stk.push(new int[]{val, val});
        } else {
            int currentMin = stk.peek()[1];
            stk.push(new int[]{val, Math.min(val, currentMin)});
        }
    }

    public void pop() {
        if (stk.isEmpty()) throw new RuntimeException("Pop is not possible");
        stk.pop();
    }

    public int top() {
        if (stk.isEmpty()) throw new RuntimeException("Stack is Empty");
        return stk.peek()[0];
    }

    public int getMin() {
        if (stk.isEmpty()) throw new RuntimeException("Stack is Empty");
        return stk.peek()[1];
    }
}