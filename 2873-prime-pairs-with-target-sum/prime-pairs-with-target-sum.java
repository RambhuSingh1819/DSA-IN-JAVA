class Solution {
    public List<List<Integer>> findPrimePairs(int n) {
        List<List<Integer>> list = new ArrayList<>();

        if(n < 4) return list;

        boolean[] check = new boolean[n+1];
        check[0] = check[1] = true;

        for(int i = 2; i * i < n; i++){
           if(!check[i]) {
            for(int j = i * i; j < n; j += i) check[j] = true;
           }
        }
        
        for(int i = 0; i <= n / 2; i++){
            int y = n - i;
            if(!check[i] && !check[y]) list.add(Arrays.asList(i,y));
        }
        return list;
    }
   
}