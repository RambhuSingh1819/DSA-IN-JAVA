class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int ele : nums){
            map.put(ele,map.getOrDefault(ele,0)+1);
        }
        if(k == n){
            int ans = -1;
            for(int ele : nums) ans = Math.max(ele,ans);
            return ans;
        }
        if(k == 1){
            int ans = -1;
            for(Map.Entry<Integer,Integer> entry : map.entrySet()){
                if(entry.getValue() == 1){
                    ans = Math.max(ans,entry.getKey());
                }
            }
            return ans;
        }
        int ans = -1;

        if(map.get(nums[0]) == 1){
            ans = Math.max(ans,nums[0]);
        }
        if(map.get(nums[n-1]) == 1){
            ans = Math.max(ans,nums[n-1]);
        }
        return ans;
    }
}