class Solution {
    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;

        List<List<Integer>> original = new ArrayList<>();
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            original.add(new ArrayList<>());
            adj.add(new ArrayList<>());
        }

        // Build the original tree
        for (int i = 1; i < n; i++) {
            original.get(parent[i]).add(i);
        }

        // Build modified tree
        int[] last = new int[26];
        Arrays.fill(last, -1);

        build(0, original, adj, s, last);

        // Calculate subtree sizes
        int[] ans = new int[n];
        dfs(0, adj, ans);

        return ans;
    }

    private void build(int node, List<List<Integer>> original,
                      List<List<Integer>> adj, String s, int[] last) {

        int ch = s.charAt(node) - 'a';

        int previous = last[ch];
        last[ch] = node;

        for (int child : original.get(node)) {
            int c = s.charAt(child) - 'a';

            int newParent;

            if (last[c] != -1) {
                newParent = last[c];
            } else {
                newParent = node;
            }

            adj.get(newParent).add(child);

            build(child, original, adj, s, last);
        }

        // Backtrack: restore the previous ancestor
        last[ch] = previous;
    }

    private int dfs(int node, List<List<Integer>> adj, int[] ans) {
        int size = 1;

        for (int child : adj.get(node)) {
            size += dfs(child, adj, ans);
        }

        ans[node] = size;
        return size;
    }
}