class Solution {
    public boolean sumGame(String num) {
        int n = num.length();
        int sumDiff = 0;
        int qDiff = 0;

        for (int i = 0; i < n; i++) {
            int sign = (i < n / 2) ? 1 : -1;
            char ch = num.charAt(i);

            if (ch == '?') {
                qDiff += sign;
            } else {
                sumDiff += sign * (ch - '0');
            }
        }

        // If the difference in '?' count is odd, Alice gets the last move and can always win
        if ((qDiff & 1) != 0) {
            return true;
        }

        // For Bob to win, each pair of '?' on the unbalanced side must contribute an average sum of 9
        // sumDiff + (qDiff / 2) * 9 must equal 0
        return sumDiff + (qDiff / 2) * 9 != 0;
    }
}