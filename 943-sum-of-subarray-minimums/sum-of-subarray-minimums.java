class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;

        int[] pse = PSE(arr);
        int[] nse = NSE(arr);

        long total = 0;
        int mod = (int)(1e9 + 7);

        for (int i = 0; i < n; i++) {
            int left = i - pse[i];
            int right = nse[i] - i;

            total = (total + (left * 1L * right * arr[i]) % mod) % mod;
        }

        return (int) total;
    }
    public int[] NSE(int[] arr) {
        int n = arr.length;
        Stack<Integer> stk = new Stack<>();
        int[] ans = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            while (!stk.isEmpty() && arr[stk.peek()] >= arr[i]) {
                stk.pop();
            }
            ans[i] = stk.isEmpty() ? n : stk.peek();
            stk.push(i);
        }

        return ans;
    }
    public int[] PSE(int[] arr) {
        int n = arr.length;
        Stack<Integer> stk = new Stack<>();
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            while (!stk.isEmpty() && arr[stk.peek()] > arr[i]) {
                stk.pop();
            }
            ans[i] = stk.isEmpty() ? -1 : stk.peek();
            stk.push(i);
        }

        return ans;
    }
}