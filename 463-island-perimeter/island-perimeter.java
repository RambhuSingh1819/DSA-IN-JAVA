class Solution {
    public int islandPerimeter(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int totalCnt = 0; // Keep track of total perimeter
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, -1, 0, 1};
        int[][] vis = new int[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && vis[i][j] == 0) {
                    // Accumulate the perimeter returned by BFS
                    totalCnt += bfs(i, j, grid, vis, dr, dc);
                }
            }
        }
        return totalCnt;
    }
    
    public int bfs(int row, int col, int[][] grid, int[][] vis, int[] dr, int[] dc) {
        int n = grid.length;
        int m = grid[0].length;
        vis[row][col] = 1;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{row, col});
        int localCnt = 0; // Local counter for this island
        
        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int r = temp[0];
            int c = temp[1];

            for (int i = 0; i < 4; i++) {
                int nr = dr[i] + r;
                int nc = dc[i] + c;

                // If the neighbor is out of bounds OR is water, it's a perimeter edge
                if (nr < 0 || nr >= n || nc < 0 || nc >= m || grid[nr][nc] == 0) {
                    localCnt++;
                } 
                // If the neighbor is unvisited land, mark it and push to queue
                else if (vis[nr][nc] == 0 && grid[nr][nc] == 1) {
                    vis[nr][nc] = 1;
                    q.add(new int[]{nr, nc});
                }
            }
        }
        return localCnt;
    }
}