class Solution {
    public int missingInteger(int[] nums) {
        int n = nums.length;
        int ans = nums[0];
        for(int i = 1; i < n; i++){
            if(nums[i] == nums[i-1]+1) ans += nums[i];
            else break;
        }
        Set<Integer> map = new HashSet<>();
        for(int ele : nums){
            map.add(ele);
        }
    while(map.contains(ans)) ans = ans+1;
    return ans;
        
    }
}