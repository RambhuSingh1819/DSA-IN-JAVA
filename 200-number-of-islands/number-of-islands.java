class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int cnt = 0;
        boolean[][] vis = new boolean[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                char ch = grid[i][j];
                if(!vis[i][j] && ch == '1') {
                    cnt++;
                    dfs(i,j,grid,vis);
                }
            }
        }
        return cnt;
    }
    public void dfs(int row, int col,char[][] grid, boolean[][] vis){
        int n = grid.length;
        int m = grid[0].length;
        int[][] dr = {{-1,0},{0,-1},{0,1},{1,0}};
        vis[row][col] = true;
        for(int[] dir : dr){
            int nr = row + dir[0];
            int nc = col + dir[1];
            if(nr >= 0 && nr < n && nc >= 0 && nc < m && !vis[nr][nc] && grid[nr][nc] == '1')
                dfs(nr,nc,grid,vis);
        }

    }
}