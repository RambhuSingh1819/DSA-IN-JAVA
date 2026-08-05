class Solution {
    public void dfs(int node, boolean[] vis,List<List<Integer>> adj){
        vis[node] = true;
        for(int ele : adj.get(node)){
            if(!vis[ele]) dfs(ele,vis,adj);
        }
    }

    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for(int[] it : invocations){
            int u = it[0];
            int v = it[1];
            adj.get(u).add(v);
        }
        boolean[] vis = new boolean[n];
        dfs(k,vis,adj);

        for(int[] ele : invocations){
            int node = ele[0];
            int node2 = ele[1];
            if(!vis[node] && vis[node2]){
                List<Integer> ans = new ArrayList<>();
                for(int i = 0; i < n; i++){
                    ans.add(i);
                }
                return ans;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(!vis[i]) ans.add(i);
        }
        return ans;
    }
}