class Solution {
    public long countBadPairs(int[] nums) {
        HashMap<Long,Long> map = new HashMap<>();
        int n = nums.length;
        long totalPair =(long) n * ( n- 1)/2;
        long goodPair = 0;
        for(int i = 0; i < n; i++){
            long diff = nums[i]-i;
            if(map.containsKey(diff)){
                goodPair += map.get(diff);
                map.put(diff, map.get(diff) + 1);
            }
            else map.put(diff,1L);
        }
        return totalPair - goodPair;
    }
}