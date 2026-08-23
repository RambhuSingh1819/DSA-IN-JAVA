class Solution {
    public boolean sumGame(String num) {
        int n = num.length();

        int leftSum = 0;
        int rightSum = 0;
        int leftQMark = 0;
        int rightQMark = 0;

        for (int i = 0; i < n; i++) {
            char ch = num.charAt(i);
            if (ch == '?') {
                if (i < n / 2) {
                    leftQMark++;
                } else {
                    rightQMark++;
                }
            } else {
                if (i < n / 2) {
                    leftSum += ch - '0';
                } else {
                    rightSum += ch - '0';
                }
            }
        }

        // If total '?' is odd, Alice gets the last move and guarantees a win
        int totalQ = leftQMark + rightQMark;
        if (totalQ % 2 == 1) return true;

        // Bob wins if and only if: 2 * (leftSum - rightSum) == 9 * (rightQMark - leftQMark)
        int LEFT = 2 * leftSum + 9 * leftQMark;
        int RIGHT = 2 * rightSum + 9 * rightQMark;

        return LEFT != RIGHT;
    }
}