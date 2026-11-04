class Solution {
    boolean b = true;
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] vis = new int[n];
        Arrays.fill(vis,-1);
        for(int i = 0; i < n; i++){
            if(vis[i] == -1){
                vis[i] = 0;
                dfs(i,vis,graph);
            }
        }
        return b;
    }
    public void dfs(int node, int[] vis , int[][] graph){
        for(int ele : graph[node]){
            if(vis[ele] == -1){
                vis[ele] = 1 - vis[node];
                dfs(ele,vis,graph);
            }else if(vis[node] == vis[ele]) {
                b = false;
                return ;
            }
        }
        return ;
    }
}