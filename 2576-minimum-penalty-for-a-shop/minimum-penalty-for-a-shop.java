class Solution {
    public int bestClosingTime(String customers) {
        int n = customers.length();
        char[] chr = customers.toCharArray();
        int[] yCnt = new int[n + 1];
        int[] nCnt = new int[n + 1];
        for(int i = n; i > 0; i--){
            if(chr[i-1] =='N'){
                yCnt[i-1] = yCnt[i];
            }else{
                yCnt[i-1] = 1+yCnt[i];
            }
        }
        for(int i = 1; i <= n; i++){
            if(chr[i-1] =='N'){
                nCnt[i] = 1+nCnt[i-1];
            }else{
                nCnt[i] = nCnt[i-1];
            }
        }

        int minSum = Integer.MAX_VALUE;
        int hr = -1;
        for(int i = 0; i <= n; i++){
            int sum = yCnt[i]+nCnt[i];
            if(sum < minSum){
                minSum = sum;
                hr = i;
            }
        }
        return hr;
    }
}