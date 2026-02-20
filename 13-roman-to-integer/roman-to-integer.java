class Solution {
    public int romanToInt(String s) {
        int result = 0;
        for(int i = 0; i < s.length(); i++){
            int temp = Values(s.charAt(i));
            if(i < s.length()-1){
                int next = Values(s.charAt(i+1));
                if(temp < next) result -= temp;
                else result += temp;
            }else result += temp;
        }
    return result;   
    }
    public int Values(char c){
        if(c == 'I') return 1;
        if(c == 'V') return 5;
        if(c == 'X') return 10;
        if(c == 'L') return 50;
        if(c == 'C') return 100;
        if(c == 'D') return 500;
        return 1000;
    }
}