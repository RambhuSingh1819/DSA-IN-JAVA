class Solution {
    // Prime factor counts for digits 0-9: {2, 3, 5, 7}
    private static final int[][] DIGIT_FACTORS = {
        {0, 0, 0, 0}, // 0
        {0, 0, 0, 0}, // 1
        {1, 0, 0, 0}, // 2
        {0, 1, 0, 0}, // 3
        {2, 0, 0, 0}, // 4
        {0, 0, 1, 0}, // 5
        {1, 1, 0, 0}, // 6
        {0, 0, 0, 1}, // 7
        {3, 0, 0, 0}, // 8
        {0, 2, 0, 0}  // 9
    };

    public String smallestNumber(String num, long t) {
        // Step 1: Factorize t into powers of 2, 3, 5, 7
        int req2 = 0, req3 = 0, req5 = 0, req7 = 0;
        while (t % 2 == 0) { req2++; t /= 2; }
        while (t % 3 == 0) { req3++; t /= 3; }
        while (t % 5 == 0) { req5++; t /= 5; }
        while (t % 7 == 0) { req7++; t /= 7; }

        // If t has prime factors other than 2, 3, 5, 7, impossible
        if (t > 1) {
            return "-1";
        }

        int[] minCounts = getDigitCounts(req2, req3, req5, req7);
        int totalMinDigits = sum(minCounts);
        int n = num.length();

        // Step 2: If required min digits exceeds num.length(), construct smallest number directly
        if (totalMinDigits > n) {
            return buildString("", 0, totalMinDigits - totalMinDigits, minCounts);
        }

        // Step 3: Find first '0' index and precompute prefix factor counts
        int firstZero = n;
        int[][] pref = new int[n + 1][4];
        for (int i = 0; i < n; i++) {
            char c = num.charAt(i);
            if (c == '0') {
                if (firstZero == n) {
                    firstZero = i;
                }
                pref[i + 1] = pref[i].clone();
            } else {
                int d = c - '0';
                pref[i + 1][0] = pref[i][0] + DIGIT_FACTORS[d][0];
                pref[i + 1][1] = pref[i][1] + DIGIT_FACTORS[d][1];
                pref[i + 1][2] = pref[i][2] + DIGIT_FACTORS[d][2];
                pref[i + 1][3] = pref[i][3] + DIGIT_FACTORS[d][3];
            }
        }

        // Check if num itself is valid (zero-free and satisfies t)
        if (firstZero == n &&
            pref[n][0] >= req2 &&
            pref[n][1] >= req3 &&
            pref[n][2] >= req5 &&
            pref[n][3] >= req7) {
            return num;
        }

        // Step 4: Try matching the longest prefix of num
        for (int i = n - 1; i >= 0; i--) {
            // Cannot keep a prefix containing '0'
            if (i > firstZero) {
                continue;
            }

            int curDigit = num.charAt(i) - '0';
            int spaceAfter = n - 1 - i;

            for (int d = curDigit + 1; d <= 9; d++) {
                int rem2 = req2 - pref[i][0] - DIGIT_FACTORS[d][0];
                int rem3 = req3 - pref[i][1] - DIGIT_FACTORS[d][1];
                int rem5 = req5 - pref[i][2] - DIGIT_FACTORS[d][2];
                int rem7 = req7 - pref[i][3] - DIGIT_FACTORS[d][3];

                int[] counts = getDigitCounts(rem2, rem3, rem5, rem7);
                int neededLen = sum(counts);

                if (neededLen <= spaceAfter) {
                    int padOnes = spaceAfter - neededLen;
                    return buildString(num.substring(0, i), d, padOnes, counts);
                }
            }
        }

        // Step 5: If no solution of length N exists, construct smallest number of length N + 1
        int padOnes = (n + 1) - totalMinDigits;
        return buildString("", 0, padOnes, minCounts);
    }

    private int[] getDigitCounts(int c2, int c3, int c5, int c7) {
        int[] cnt = new int[10];
        c2 = Math.max(0, c2);
        c3 = Math.max(0, c3);
        c5 = Math.max(0, c5);
        c7 = Math.max(0, c7);

        cnt[8] = c2 / 3;
        c2 %= 3;

        cnt[9] = c3 / 2;
        c3 %= 2;

        cnt[4] = c2 / 2;
        c2 %= 2;

        cnt[2] = c2;
        cnt[3] = c3;
        cnt[5] = c5;
        cnt[7] = c7;

        if (cnt[2] == 1 && cnt[3] == 1) {
            cnt[2] = 0;
            cnt[3] = 0;
            cnt[6] = 1;
        }

        if (cnt[3] == 1 && cnt[4] == 1) {
            cnt[3] = 0;
            cnt[4] = 0;
            cnt[2] = 1;
            cnt[6] = 1;
        }

        return cnt;
    }

    private int sum(int[] arr) {
        int s = 0;
        for (int v : arr) s += v;
        return s;
    }

    private String buildString(String prefix, int d, int padOnes, int[] counts) {
        StringBuilder sb = new StringBuilder();
        sb.append(prefix);
        if (d > 0) {
            sb.append(d);
        }
        for (int i = 0; i < padOnes; i++) {
            sb.append('1');
        }
        for (int digit = 2; digit <= 9; digit++) {
            for (int c = 0; c < counts[digit]; c++) {
                sb.append(digit);
            }
        }
        return sb.toString();
    }
}