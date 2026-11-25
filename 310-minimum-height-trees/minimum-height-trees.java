class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        if (n == 1) return Arrays.asList(0);

        List<List<Integer>> adj = new ArrayList<>();

        int[] degree = new int[n];

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);

            degree[u]++;
            degree[v]++;
        }

        Queue<Integer> q = new LinkedList<>();

        // Add all leaf nodes
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                q.offer(i);
            }
        }

        int remaining = n;

        while (remaining > 2) {

            int size = q.size();
            remaining -= size;

            for (int i = 0; i < size; i++) {
                int node = q.poll();

                for (int neighbour : adj.get(node)) {
                    degree[neighbour]--;

                    if (degree[neighbour] == 1) {
                        q.offer(neighbour);
                    }
                }
            }
        }

        return new ArrayList<>(q);
    }
}