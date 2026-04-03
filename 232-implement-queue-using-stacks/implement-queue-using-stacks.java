class MyQueue {
    Stack<Integer> stk;

    public MyQueue() {
        stk = new Stack<>();
    }
    
    public void push(int x) {
        stk.push(x);
        
    }
    
    public int pop() {
        if(stk.isEmpty()) return -1;
        if(stk.size() == 1) return stk.pop();
        int top = stk.pop();
        int temp = pop();
        stk.push(top);
        return temp;
        
    }
    
    public int peek() {
        if(stk.isEmpty()) return -1;
        if(stk.size() == 1) return stk.peek();
        int top = stk.pop();
        int temp = peek();
        stk.push(top);
        return temp;
        
    }
    
    public boolean empty() {
        return (stk.isEmpty()) ;
        
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */