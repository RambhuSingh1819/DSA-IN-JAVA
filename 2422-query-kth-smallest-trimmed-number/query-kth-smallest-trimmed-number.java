import java.util.*;

class Solution {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int n = nums.length;
        int k = nums[0].length();
        int m = queries.length;
        int[] ans = new int[m];

        for (int i = 0; i < m; i++) {
            int kSmallest = queries[i][0];
            int sLen = queries[i][1];

            Object[][] arr = new Object[n][2];

            for (int j = 0; j < n; j++) {
                String trimmed = nums[j].substring(k - sLen);
                arr[j][0] = trimmed;
                arr[j][1] = j;
            }

            Arrays.sort(arr, (a, b) -> {
                String s1 = (String) a[0];
                String s2 = (String) b[0];
                int cmp = s1.compareTo(s2);
                if (cmp != 0) {
                    return cmp;
                }
                return Integer.compare((int) a[1], (int) b[1]);
            });
            ans[i] = (int) arr[kSmallest - 1][1];
        }

        return ans;
    }
}