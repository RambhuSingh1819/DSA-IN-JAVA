class Solution {
    Set<Integer> set = new HashSet<>();
    public List<List<Integer>> findPrimePairs(int n) {
        List<List<Integer>> list = new ArrayList<>();
        isPrime(n);
        for(int i = 0; i <= n / 2; i++){
            if(set.contains(i) && set.contains(n-i))
            list.add(Arrays.asList(i,n-i));
        }
        return list;
    }
    public void isPrime(int n){
        if(n < 2) return;
        boolean[] check = new boolean[n];
        Arrays.fill(check,true);
        check[0] = false;
        check[1] = false;

        int rem = 0;

        for(int i = 2; i * i < n; i++){
           if(check[i]) {
            for(int j = i * i; j < n; j += i) check[j] = false;
           }
        }
        for(int i = 0; i < check.length; i++){
            if(check[i]) set.add(i);
        }
    }
}