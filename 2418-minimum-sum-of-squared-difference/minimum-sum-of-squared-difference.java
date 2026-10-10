class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        int maxDiff = 0;
        int[] freq = new int[100001];
        for(int i = 0;i < n; i++){
            int diff = Math.abs(nums1[i]-nums2[i]);
            freq[diff]++;
            maxDiff = Math.max(maxDiff,diff);
        }
        long totalK = (long)k1+k2;
        for(int i = maxDiff; i > 0 ; i--){
            if(freq[i] > 0){
                long reduceCnt = Math.min(totalK, freq[i]);
                freq[i] -= reduceCnt;
                freq[i-1] += reduceCnt;
                totalK -= reduceCnt;
                if(totalK == 0) break;
            }
        }
        long ans = 0;
        for(int i = 1; i <= maxDiff; i++){
            if(freq[i] > 0){
                ans += (long)freq[i]*i*i;
            }
        }
        return ans;
    }
}