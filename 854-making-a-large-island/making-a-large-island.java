import java.util.HashSet;

class DisjointSet {
    int[] parent;
    int[] size;
    
    public DisjointSet(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }
    
    public int findParent(int node) {
        if (node == parent[node]) return node;
        return parent[node] = findParent(parent[node]);
    }
    
    public void unionBySize(int u, int v) {
        int uP = findParent(u);
        int vP = findParent(v);
        if (uP == vP) return;
        
        if (size[uP] < size[vP]) {
            parent[uP] = vP;
            size[vP] += size[uP];
        } else {
            parent[vP] = uP;
            size[uP] += size[vP];
        }
    }
}

class Solution {
    int[] dr = {0, 0, -1, 1};
    int[] dc = {1, -1, 0, 0};
    
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        DisjointSet ds = new DisjointSet(n * n);
        
        // Step 1: Connect all initial 1s into components
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) continue;
                for (int k = 0; k < 4; k++) {
                    int nr = dr[k] + i;
                    int nc = dc[k] + j;
                    if (nr >= 0 && nr < n && nc >= 0 && nc < n && grid[nr][nc] == 1) {
                        int node = i * n + j;
                        int adjNode = nr * n + nc;
                        ds.unionBySize(node, adjNode);
                    }
                }
            }
        }
        
        int ans = 0;
        
        // Step 2: Try converting each 0 to 1 and measure the new island size
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) continue;
                
                // HashSet must be outside the 4-direction loop to deduplicate correctly
                HashSet<Integer> set = new HashSet<>();
                for (int k = 0; k < 4; k++) {
                    int nr = dr[k] + i;
                    int nc = dc[k] + j;
                    
                    if (nr >= 0 && nr < n && nc >= 0 && nc < n && grid[nr][nc] == 1) {
                        set.add(ds.findParent(nr * n + nc));
                    }
                }
                
                int sizeTotal = 0;
                for (Integer parent : set) {
                    sizeTotal += ds.size[parent]; // Fix: size is an array, not a List
                }
                ans = Math.max(ans, sizeTotal + 1); // +1 for the flipped 0
            }
        }
        
        // Step 3: Handle edge case where the grid is already full of 1s (no 0s to flip)
        for (int idx = 0; idx < n * n; idx++) {
            ans = Math.max(ans, ds.size[ds.findParent(idx)]); // Fix: array syntax
        }
        
        return ans;
    }
}