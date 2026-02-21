class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        if(s.isEmpty()) return 0;
        int sign = 1;
        int i = 0;
        long num = 0;
        if(s.charAt(i) == '-' || s.charAt(i) == '+'){
            sign = (s.charAt(i)=='-') ? -1 : 1;
            i++;
        }
        while(i < s.length() && Character.isDigit(s.charAt(i))){
            int digit = s.charAt(i) - '0';
            num = num * 10 + digit;
            if(sign * num > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if(sign * num < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            i++;
        }
        return (int)(sign * num);
        
    }
}