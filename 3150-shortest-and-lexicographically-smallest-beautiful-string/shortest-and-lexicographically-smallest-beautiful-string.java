class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        int i = 0;
        int cnt = 0;
        String ans = "";
        for (int j = 0; j < n; j++) {
            if (s.charAt(j) == '1') {
                cnt++;
            }
            while (cnt == k) {
                while (s.charAt(i) == '0') {
                    i++;
                }

                String current = s.substring(i, j + 1);
                if (ans.isEmpty() || current.length() < ans.length()) {
                    ans = current;
                } else if (current.length() == ans.length() && current.compareTo(ans) < 0) {
                    ans = current;
                }
                if (s.charAt(i) == '1') {
                    cnt--;
                }
                i++;
            }
        }
        return ans;
    }
}