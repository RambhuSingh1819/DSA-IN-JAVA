class Pair{
    int first;
    int sec;
    public Pair(int first, int sec){
        this.first = first;
        this.sec = sec;
    }
}
class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] visited = new int[m][n];
        int cnt = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(visited[i][j] == 0 && grid[i][j] == '1') {
                    cnt++;
                    bfs(i, j, visited, grid);
                }
            }
        }
        return cnt;      
    }
    public void bfs(int ro, int co, int[][] visited, char[][] grid){
        visited[ro][co] = 1;
        Queue<Pair> q = new LinkedList<Pair>();
        q.offer(new Pair(ro,co));

        int m = grid.length;
        int n = grid[0].length;

        int[] deltaRow = {-1,0,1,0};
        int[] deltaCol = {0,1,0,-1};

        while(!q.isEmpty()){
            Pair p = q.poll();
            int row = p.first;
            int col = p.sec;

            

            for(int i = 0; i < 4 ; i++){              
                int nrow = deltaRow[i] + row;
                int ncol = deltaCol[i] + col;

                if(nrow >= 0 && nrow < m && ncol >= 0 && 
                    ncol < n && grid[nrow][ncol] =='1' &&
                    visited[nrow][ncol] == 0){
                        visited[nrow][ncol] = 1;
                        q.offer(new Pair(nrow, ncol)); 

                }
            }
        }
    }
}