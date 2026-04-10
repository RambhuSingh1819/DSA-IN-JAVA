class StockSpanner {

    Stack<int[]> stk;

    public StockSpanner() {
        stk = new Stack<>();
    }
    public int next(int price) {
        int cnt = 1;
        while(!stk.isEmpty()&& stk.peek()[0] <= price){
            cnt += stk.peek()[1];
            stk.pop();
        }
         stk.push(new int[]{price, cnt});

        return cnt;
        
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */