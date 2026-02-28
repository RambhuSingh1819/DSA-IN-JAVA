class Solution {
    public int maxDistance(int[] position, int m) {
        int n = position.length;
        if(n < m) return 0;
        Arrays.sort(position);
        int low = 1;
        int high = position[n-1]-position[0];
        if(m == 2) return high;
        int ans = 0;
        while(low <= high){
            int mid = low + (high - low )/2;
            if(isPossible(position,mid,m)){
                ans = mid;
                low = mid + 1;
            }else high = mid - 1;
        }
        return ans;
    }
    public boolean isPossible(int[] nums, int mid, int k){
        int found = 1;
        int index = nums[0];
        for(int i = 1 ; i < nums.length; i++){
            if(nums[i]-index >= mid){
                found++;
                index = nums[i];
            }
            if(found >= k) return true;
        }
        return false;
    }
}