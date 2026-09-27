class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int n = isWater.length;
        int m = isWater[0].length;
        Queue<int[]> q= new LinkedList<>();
        boolean[][] vis = new boolean[n][m];
        for(int i= 0; i < n; i++){
            for(int j  = 0; j < m; j++){
                if(isWater[i][j] == 1){
                    isWater[i][j] = 0;
                    vis[i][j] = true;
                    q.add(new int[]{i,j});
                }else{
                    isWater[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];

            for(int[] dr : dir){
                int nr = dr[0]+r;
                int nc = dr[1]+ c;
                if(nr >= 0 && nc >= 0 && nr < n && nc < m && isWater[nr][nc] > isWater[r][c] && !vis[nr][nc]){
                    isWater[nr][nc] = 1 + isWater[r][c];
                    vis[nr][nc] = true;
                    q.add(new int[]{nr,nc});
                }
            }
        }
        return isWater;
    }
}