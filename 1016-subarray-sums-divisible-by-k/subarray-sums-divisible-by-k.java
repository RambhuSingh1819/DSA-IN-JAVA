class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        int[] remFreq = new int[k];
        int cnt = 0;
        remFreq[0] = 1;
        int prefixSum = 0;
        for(int i = 0; i < n; i++){
            prefixSum += nums[i];
            int rem = ((prefixSum % k)+k)%k;
            cnt += remFreq[rem];
            remFreq[rem]++;
        }
        return cnt;
    }
}