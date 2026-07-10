import java.util.*;

class Solution {

    int rows;
    int cols;
    int[][] ancestorTable;

    private int customUpperBound(List<int[]> arr, int target) {
        int n = arr.size();

        int l = 0;
        int r = n - 1;
        int result = 0;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (arr.get(mid)[0] <= target) {
                result = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return result;
    }

    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {

        List<int[]> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr.add(new int[]{nums[i], i});
        }

        arr.sort((a, b) -> Integer.compare(a[0], b[0]));

        int[] nodeToIdx = new int[n];

        for (int i = 0; i < n; i++) {
            int node = arr.get(i)[1];
            nodeToIdx[node] = i;
        }

        rows = n;
        cols = (int)(Math.log(n) / Math.log(2)) + 1;

        ancestorTable = new int[rows][cols];

        // Fill first column
        for (int node = 0; node < n; node++) {
            int farthestIdxOneHop =
                    customUpperBound(arr, arr.get(node)[0] + maxDiff);

            ancestorTable[node][0] = farthestIdxOneHop;
        }

        // Fill remaining columns (Binary Lifting)
        for (int j = 1; j < cols; j++) {
            for (int node = 0; node < n; node++) {
                ancestorTable[node][j] =
                        ancestorTable[
                                ancestorTable[node][j - 1]
                        ][j - 1];
            }
        }

        int[] result = new int[queries.length];

        int idx = 0;

        for (int[] query : queries) {

            int u = query[0];
            int v = query[1];

            int a = nodeToIdx[u];
            int b = nodeToIdx[v];

            if (a == b) {
                result[idx++] = 0;
                continue;
            }

            if (a > b) {
                int temp = a;
                a = b;
                b = temp;
            }

            int curr = a;
            int jumps = 0;

            for (int j = cols - 1; j >= 0; j--) {

                if (ancestorTable[curr][j] < b) {
                    curr = ancestorTable[curr][j];
                    jumps += (1 << j);
                }
            }

            if (ancestorTable[curr][0] >= b) {
                result[idx++] = jumps + 1;
            } else {
                result[idx++] = -1;
            }
        }

        return result;
    }
}