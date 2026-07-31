class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] relation : relations) {
            adj.get(relation[0]).add(relation[1]);
        }
        int[] memo = new int[n + 1];
        int maxMonths = 0;
        for (int i = 1; i <= n; i++) {
            maxMonths = Math.max(maxMonths, dfs(i, adj, time, memo));
        }
        
        return maxMonths;
    }

    private int dfs(int node, List<List<Integer>> adj, int[] time, int[] memo) {
        if (memo[node] != 0) {
            return memo[node];
        }

        int maxPathFromNeighbors = 0;

        for (int neighbor : adj.get(node)) {
            maxPathFromNeighbors = Math.max(maxPathFromNeighbors, dfs(neighbor, adj, time, memo));
        }
        memo[node] = time[node - 1] + maxPathFromNeighbors;
        
        return memo[node];
    }
}