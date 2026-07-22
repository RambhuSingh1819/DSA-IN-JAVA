class Solution {
    public List<Integer> maxActiveSectionsAfterTrade(String s, int[][] queries) {
        int n = s.length();
        int[] prefOnes = new int[n + 1];
        int[] nextZero = new int[n];
        int[] prevZero = new int[n];
        
        int lastZ = -1;
        for (int i = 0; i < n; i++) {
            prefOnes[i + 1] = prefOnes[i] + (s.charAt(i) - '0');
            if (s.charAt(i) == '0') {
                lastZ = i;
            }
            prevZero[i] = lastZ;
        }
        
        lastZ = n;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                lastZ = i;
            }
            nextZero[i] = lastZ;
        }
        
        List<Integer> zList = new ArrayList<>();
        List<Integer> zStarts = new ArrayList<>();
        List<Integer> zEnds = new ArrayList<>();
        List<Integer> oList = new ArrayList<>();
        
        int i = 0;
        int lastZeroBlockEnd = -1;
        while (i < n) {
            if (s.charAt(i) == '0') {
                int start = i;
                while (i < n && s.charAt(i) == '0') i++;
                int end = i - 1;
                zList.add(end - start + 1);
                zStarts.add(start);
                zEnds.add(end);
                
                if (lastZeroBlockEnd != -1) {
                    oList.add(start - lastZeroBlockEnd - 1);
                }
                lastZeroBlockEnd = end;
            } else {
                i++;
            }
        }
        
        int zSize = zList.size();
        int[] maxZ = new int[zSize];
        int[] minO = new int[Math.max(1, zSize - 1)];
        int[] maxZSum = new int[Math.max(1, zSize - 1)];
        
        for (int j = 0; j < zSize; j++) maxZ[j] = zList.get(j);
        for (int j = 0; j < zSize - 1; j++) {
            minO[j] = oList.get(j);
            maxZSum[j] = zList.get(j) + zList.get(j + 1);
        }
        
        SparseTable stMaxZ = new SparseTable(maxZ, true);
        SparseTable stMinO = new SparseTable(minO, false);
        SparseTable stMaxZSum = new SparseTable(maxZSum, true);
        
        int qCount = queries.length;
        List<Integer> ans = new ArrayList<>(qCount);
        
        // Find which block a '0' belongs to
        int[] zeroBlockIdx = new int[n];
        int bIdx = 0;
        for (int j = 0; j < n; j++) {
            if (s.charAt(j) == '0') {
                if (j > zEnds.get(bIdx)) bIdx++;
                zeroBlockIdx[j] = bIdx;
            }
        }
        
        // Get the total number of '1's in the entire string!
        int totalOnes = prefOnes[n];
        
        for (int q = 0; q < qCount; q++) {
            int L = queries[q][0];
            int R = queries[q][1];
            
            int L0 = nextZero[L];
            int R0 = prevZero[R];
            
            if (L0 > R || R0 < L || L0 > R0) {
                // No zeros in substring -> No valid trade
                ans.add(totalOnes);
                continue;
            }
            
            int a = zeroBlockIdx[L0];
            int b = zeroBlockIdx[R0];
            
            if (a == b) {
                // All zeros in the substring belong to the same block -> No valid trade
                ans.add(totalOnes);
            } else {
                int z1 = zEnds.get(a) - L0 + 1;
                int zk = R0 - zStarts.get(b) + 1;
                
                int M = Math.max(z1, zk);
                if (b - a >= 2) {
                    M = Math.max(M, stMaxZ.query(a + 1, b - 1));
                }
                
                int O_min = stMinO.query(a, b - 1);
                
                int maxAdj = 0;
                if (b - a == 1) {
                    maxAdj = z1 + zk;
                } else {
                    maxAdj = Math.max(z1 + zList.get(a + 1), zList.get(b - 1) + zk);
                    if (b - a >= 3) {
                        maxAdj = Math.max(maxAdj, stMaxZSum.query(a + 1, b - 2));
                    }
                }
                
                // Determine the maximum increase a trade will net us in this query bounds
                int maxChange = Math.max(maxAdj, M - O_min);
                ans.add(totalOnes + maxChange);
            }
        }
        
        return ans;
    }
    
    // Static Sparse Table structure 
    class SparseTable {
        int[][] st;
        boolean isMax;
        int[] log2;
        
        SparseTable(int[] arr, boolean isMax) {
            this.isMax = isMax;
            int n = arr.length;
            if (n == 0) return;
            log2 = new int[n + 1];
            for (int k = 2; k <= n; k++) log2[k] = log2[k / 2] + 1;
            
            int K = log2[n] + 1;
            st = new int[K][n];
            for (int k = 0; k < n; k++) st[0][k] = arr[k];
            
            for (int j = 1; j < K; j++) {
                for (int k = 0; k + (1 << j) <= n; k++) {
                    if (isMax) {
                        st[j][k] = Math.max(st[j - 1][k], st[j - 1][k + (1 << (j - 1))]);
                    } else {
                        st[j][k] = Math.min(st[j - 1][k], st[j - 1][k + (1 << (j - 1))]);
                    }
                }
            }
        }
        
        int query(int L, int R) {
            int j = log2[R - L + 1];
            if (isMax) {
                return Math.max(st[j][L], st[j][R - (1 << j) + 1]);
            } else {
                return Math.min(st[j][L], st[j][R - (1 << j) + 1]);
            }
        }
    }
}