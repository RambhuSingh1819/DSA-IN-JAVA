class DisjointSet{
    int[] parent;
    int[] size;
    int[] rank;
    public DisjointSet(int n){
        parent = new int[n];
        size = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
            size[i] = 1;
        }
    }
    public int findUParent(int node){
        if(node == parent[node]) return node;
        return parent[node] = findUParent(parent[node]);
    }
    public void unionBySize(int u, int v){
        int pu = findUParent(u);
        int pv = findUParent(v);
        if(pu == pv) return;
        if(size[pu] < size[pv]) {
            parent[pu] = pv;
            size[pv] += size[pu];
        }else {
            parent[pv] = pu;
            size[pu] += size[pv];
        }
    }
    public void unionByRank(int u, int v){
        int pu = findUParent(u);
        int pv = findUParent(v);
        if(pu == pv) return ;
        if(rank[pu] < rank[pv]) parent[pv] = pu;
        else if(rank[pv] < rank[pu]) parent[pu] = pv;
        else {
            parent[pv] = pu;
            rank[pu] = rank[pu]+1;
        }
    }
}
class Solution {
    public int makeConnected(int n, int[][] connections) {
        DisjointSet ds = new DisjointSet(n);
        int extra = 0;
        int m = connections.length;
        for(int i = 0; i < m; i++){
            int U = connections[i][0];
            int V = connections[i][1];
            if(ds.findUParent(U) == ds.findUParent(V)) extra++;
            else ds.unionBySize(U,V);
        }
        int cntComp = 0;
        for(int i = 0; i < n; i++){
            if(ds.findUParent(i) == i) cntComp++;
        }
        int ans = cntComp-1;
        if(extra >= ans) return ans;
        return -1;       
    }
}