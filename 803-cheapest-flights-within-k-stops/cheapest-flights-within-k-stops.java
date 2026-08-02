class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        if(n == 0) return -1;

        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] it : flights) {
            adj.get(it[0]).add(new int[]{it[1], it[2]});
        }

        int[] dis = new int[n];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[src] = 0;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,src,0});
       

        while(!q.isEmpty()){
                int[] temp = q.poll();
                int cnt = temp[0];
                int u = temp[1];
                int cost = temp[2];

                if(cnt > k) continue;

                for(int[] neighbour : adj.get(u)){
                    int v = neighbour[0];
                    int cst = neighbour[1];

                    if(dis[v] > cost + cst){
                        dis[v] = cost + cst;
                        q.add(new int[]{cnt+1,v,dis[v]});
                    }
                }
            }
        return dis[dst] == Integer.MAX_VALUE ? -1 : dis[dst];
    }
}