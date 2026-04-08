import java.util.*;

class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        if(k == n) return "0";
        Stack<Character> stk = new Stack<>();

        for (int i = 0; i < n; i++) {
            char ch = num.charAt(i);

            while (!stk.isEmpty() && k > 0 && stk.peek() > ch) {
                stk.pop();
                k--;
            }

            stk.push(ch);
        }

        // If k still remains
        while (k > 0 && !stk.isEmpty()) {
            stk.pop();
            k--;
        }

        // Build result
        StringBuilder res = new StringBuilder();

        while (!stk.isEmpty()) {
            res.append(stk.pop());
        }

        res.reverse();

        // Remove leading zeros
        while (res.length() > 1 && res.charAt(0) == '0') {
            res.deleteCharAt(0);
        }

        return res.toString();
    }
}