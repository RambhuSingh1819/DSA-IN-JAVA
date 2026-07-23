class Pair{
    int first;
    int sec;
    int tm;
    Pair(int first,int sec , int tm){
        this.first = first;
        this.sec = sec;
        this.tm = tm;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<Pair> q = new LinkedList<Pair>();

        int[][] vis = new int[n][m];

        int cntFrest = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 2){
                    q.add(new Pair(i,j,0));
                    vis[i][j] = 2;
                }else{
                    vis[i][j] = 0;
                } 
                if(grid[i][j]==1) cntFrest++;
            }
        }
        int tm = 0;
        int[] drow = {-1, 0, +1, 0};
        int[] dcol = {0, +1, 0, -1};

        int cnt = 0;
        while(!q.isEmpty()){
           Pair p =  q.poll();
           int r = p.first;
           int c = p.sec;
           int t = p.tm;

           tm = Math.max(tm,t);
            for(int i = 0; i < 4 ; i++){
                int nrow = r + drow[i];
                int ncol = c + dcol[i];

                if(nrow >= 0 && nrow < n && ncol >=0 && ncol < m
                    && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1){
                        q.add(new Pair(nrow,ncol, t+1));
                        vis[nrow][ncol] = 2;
                        cnt++;
                    }
            }
        }
        if(cnt != cntFrest) return -1;
        return tm;
       
    }
}