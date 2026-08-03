class Solution {
    public int countPaths(int n, int[][] roads) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++)adj.add(new ArrayList<>());

        for(int[] it : roads){
            int u = it[0];
            int v = it[1];
            int wt = it[2];

            adj.get(u).add(new int[]{v,wt});
            adj.get(v).add(new int[]{u,wt});
        }
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;

        long[] ways = new long[n];
        ways[0] = 1;

        int MOD =(int)(1e9+7);

        PriorityQueue<long[]> pq = new PriorityQueue<>((a,b)->Long.compare(a[0],b[0]));
        pq.add(new long[]{0,0});

        while(!pq.isEmpty()){
            long[] curr = pq.poll();
            long cost = curr[0];
            int node = (int)curr[1];

            if(cost > dist[node]) continue; 

            for(int[] it : adj.get(node)){

                int U = it[0];
                long wt = it[1];
                
                if(dist[U] > wt+cost){
                    dist[U] =wt+cost;
                    pq.add(new long[]{dist[U],U});
                    ways[U] = ways[node];
                }
                else if(wt+cost == dist[U]){
                    ways[U] = (ways[U] + ways[node])%MOD;
                }
            }
        }
        return (int)(ways[n-1]);
    }
}