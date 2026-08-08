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
        if(size[pu] < size[pv]){
            parent[pu] = pv;
            size[pv] += size[pu];
        }else{
            parent[pv] = pu;
            size[pu] += size[pv];
        }
    }
    public void unionByRank(int u, int v){
        int pu = findUParent(u);
        int pv = findUParent(v);
        if(pu == pv) return;
        if(rank[pu] < rank[pv]){
            parent[pu] = pv;
        }
        else if(rank[pv] < rank[pu]) parent[pv] = pu;
        else{
            parent[pv] = pu;
            rank[pu] = rank[v]+1;
        }
    }
}
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DisjointSet ds = new DisjointSet(n);
        HashMap<String,Integer> map_M_N = new HashMap<>();
        for(int i = 0; i < n; i++){
            for(int j = 1; j < accounts.get(i).size(); j++){
                String mail = accounts.get(i).get(j);
                if(map_M_N.containsKey(mail) == false){
                    map_M_N.put(mail,i);
                }
                else {
                    ds.unionBySize(i,map_M_N.get(mail));
                }
            }
        }
        ArrayList<String>[] mergeMail = new ArrayList[n];
        for(int i = 0; i < n; i++){
            mergeMail[i] = new ArrayList<String>();
        }

        for(Map.Entry<String,Integer> it : map_M_N.entrySet()){
            String mail = it.getKey();
            int node = ds.findUParent(it.getValue());
            mergeMail[node].add(mail);
        }
        List<List<String>> ans = new ArrayList<>();
        for(int i = 0; i < n ;i++){
            if(mergeMail[i].size() == 0) continue;
            Collections.sort(mergeMail[i]);
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            for(String It : mergeMail[i]){
                temp.add(It);
            }
            ans.add(temp);
        }
    return ans;
    }
}