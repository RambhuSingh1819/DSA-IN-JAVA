class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;

        List<List<Integer>> ans = new ArrayList<>();
        if(n == 0) return ans;
        List<Integer> temp = new ArrayList<>();
        temp.add(0);
        dfs(0,graph,temp,ans);
        return ans;
    }
    public void dfs(int node,int[][] graph,List<Integer> temp,List<List<Integer>> ans){
        
        if(node == graph.length-1){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int it : graph[node]){
           temp.add(it);
           dfs(it,graph,temp,ans);   
           temp.remove(temp.size() - 1);
        }
        return ;
    }
}