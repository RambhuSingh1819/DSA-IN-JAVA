class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n = rocks.length;
        int[] temp = new int[n];
        for(int i = 0; i < n; i++){
            temp[i] = capacity[i] - rocks[i];
        }
        Arrays.sort(temp);
        int cnt = 0;
        for(int idx : temp){
            if(idx <= additionalRocks) {
                additionalRocks -= idx;
                cnt++;
            }
            else break;
        }
     return cnt;   
    }
}