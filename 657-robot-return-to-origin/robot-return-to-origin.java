class Solution {
    public boolean judgeCircle(String moves) {
        int n = moves.length();
        if(n == 0) return true;
        int x= 0;
        int y = 0;
        for(int i = 0; i < n; i++){
            char ch  = moves.charAt(i);
            if(ch == 'U') y++;
            if(ch == 'R') x++;
            if(ch == 'L') x--;
            if(ch == 'D') y--;
        }
        return x == 0 & y == 0;       
    }
}