class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int fresh = 0;
        Queue<int[]> q = new LinkedList<>();
        int[][] vis = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 2){
                    vis[i][j] = 2;
                    q.add(new int[]{i,j,0});
                }
                if(grid[i][j] == 1) fresh++;
            }
        }

        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};
        int cnt = 0;
        int time = 0;
        while(!q.isEmpty()){
            int len = q.size();
            for(int i = 0; i < len; i++){
                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];
                int t = curr[2];
                time = Math.max(time,t);
                for(int k = 0; k < 4; k++){
                    int nr = r + dr[k];
                    int nc = c + dc[k];
                    if(nr >= 0 && nr < n && nc >= 0 && nc < m && vis[nr][nc] == 0 && grid[nr][nc] == 1){
                        vis[nr][nc] = 2;
                        q.add(new int[]{nr,nc,t+1});
                        cnt++;
                    }
                }
            }
        }
        if(cnt != fresh) return -1;
        return time;    
    
    }
}