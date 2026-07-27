class Solution {
    public int countIslands(int[][] grid, int k) {
        int cnt = 0;
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};
        int[][] b = new int[m][n];

        for(int i = 0; i < m ; i++){
            for(int j = 0; j < n ; j++){
                if(b[i][j] == 0 && grid[i][j] > 0){
                    long ans = dfs(i,j,b,grid,dir);
                    if(ans % k == 0)cnt++;
                }
            }
        }
        return cnt;
    }
    public long dfs(int row, int col, int[][] vis, int[][] grid, int[][] dir){

        int m = grid.length;
        int n = grid[0].length;

        vis[row][col] = 1;
        long ans = grid[row][col];

        for(int[] xy : dir){
            int nr = row + xy[0];
            int nc = col + xy[1];

            if(nr >= 0 && nr < m && nc >= 0 && nc < n && 
                vis[nr][nc] == 0 && grid[nr][nc] >0){
                    ans += dfs(nr, nc, vis, grid, dir);
            }


        }
        return ans;
    }
}