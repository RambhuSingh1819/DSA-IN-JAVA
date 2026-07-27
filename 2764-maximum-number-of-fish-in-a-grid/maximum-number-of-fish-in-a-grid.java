class Solution {
    public int findMaxFish(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] vis = new int[m][n];
        int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};

        int ans = 0;

        for(int i = 0; i < m ; i++){
            for(int j = 0; j < n; j++){
                if(vis[i][j] == 0 && grid[i][j] > 0){
                    int total = dfs(i,j,vis,grid,dir);
                    ans = Math.max(ans,total);
                }
            }
        }
        return ans;      
    }
    public int dfs(int row, int col , int[][] vis, int[][] grid, int[][] dir){
        int m = grid.length;
        int n = grid[0].length;

        vis[row][col] = 1;

        int totalFishCnt = grid[row][col];
        
        for(int[] xy : dir){
            int nr = row + xy[0];
            int nc = col + xy[1];

            if(nr >= 0 && nr < m && nc >= 0 && nc < n &&
                vis[nr][nc] == 0 && grid[nr][nc] > 0)

                    totalFishCnt += dfs(nr, nc, vis , grid, dir);
        }
        return totalFishCnt;

    }
}