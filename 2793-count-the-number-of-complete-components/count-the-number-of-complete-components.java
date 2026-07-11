import java.util.*;

class Solution {

    class DSU {

        int[] parent;
        int[] size;

        DSU(int n) {
            parent = new int[n];
            size = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        int find(int x) {
            if (parent[x] == x) {
                return x;
            }

            return parent[x] = find(parent[x]); // Path Compression
        }

        void union(int x, int y) {

            int xPar = find(x);
            int yPar = find(y);

            if (xPar == yPar)
                return;

            // Union by Size
            if (size[xPar] > size[yPar]) {
                parent[yPar] = xPar;
                size[xPar] += size[yPar];
            } else if (size[xPar] < size[yPar]) {
                parent[xPar] = yPar;
                size[yPar] += size[xPar];
            } else {
                parent[xPar] = yPar;
                size[yPar] += size[xPar];
            }
        }
    }

    public int countCompleteComponents(int n, int[][] edges) {

        DSU dsu = new DSU(n);

        // Build connected components
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            dsu.union(u, v);
        }

        // root -> number of edges
        HashMap<Integer, Integer> edgeCount = new HashMap<>();

        // Count edges in each component
        for (int[] edge : edges) {

            int root = dsu.find(edge[0]);

            edgeCount.put(root,
                    edgeCount.getOrDefault(root, 0) + 1);
        }

        int result = 0;

        for (int i = 0; i < n; i++) {

            // If i is the parent(root)
            if (dsu.find(i) == i) {

                int vertices = dsu.size[i];

                int edgesInComponent =
                        edgeCount.getOrDefault(i, 0);

                // Complete Graph Condition
                if ((vertices * (vertices - 1)) / 2
                        == edgesInComponent) {

                    result++;
                }
            }
        }

        return result;
    }
}