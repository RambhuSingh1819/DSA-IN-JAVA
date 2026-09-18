import java.util.*;

class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, -1);
        Arrays.fill(last, -1);

        // 1. Record the first and last occurrence of each character
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            if (first[c] == -1) {
                first[c] = i;
            }
            last[c] = i;
        }

        // 2. Find all minimal valid intervals
        List<int[]> intervals = new ArrayList<>();

        for (int i = 0; i < 26; i++) {
            if (first[i] == -1) continue;

            int left = first[i];
            int right = last[i];
            boolean isValid = true;

            // Expand interval to cover all characters appearing within [left, right]
            for (int j = left; j <= right; j++) {
                int c = s.charAt(j) - 'a';

                // If a character inside starts before 'left', this cannot be a minimal interval starting at 'left'
                if (first[c] < left) {
                    isValid = false;
                    break;
                }
                right = Math.max(right, last[c]);
            }

            if (isValid) {
                intervals.add(new int[]{left, right});
            }
        }

        // 3. Greedy Interval Scheduling: sort by ending position
        intervals.sort((a, b) -> Integer.compare(a[1], b[1]));

        List<String> result = new ArrayList<>();
        int prevEnd = -1;

        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];

            // If the interval doesn't overlap with the previously chosen one, pick it
            if (start > prevEnd) {
                result.add(s.substring(start, end + 1));
                prevEnd = end;
            }
        }

        return result;
    }
}