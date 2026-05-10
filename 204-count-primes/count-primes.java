class Solution {
    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }
        boolean[] b = new boolean[n];
        Arrays.fill(b,true);
        for(int i = 2; i * i < n; i++){
            if(b[i]){
                for(int j = i*i; j < n; j +=i) b[j] = false;
            }
        }
        int cnt = 0;
        for(int i = 2; i <n; i++){
            if(b[i]) cnt++;
        }
        return cnt; 
    }
}