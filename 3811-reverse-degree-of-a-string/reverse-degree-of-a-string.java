class Solution {
    public int reverseDegree(String s) {
        int res = 0, acc = 0;

    for (int i = s.length() - 1; i >= 0; i--)
        res += acc += '{' - s.charAt(i);

    return res;
    }
}