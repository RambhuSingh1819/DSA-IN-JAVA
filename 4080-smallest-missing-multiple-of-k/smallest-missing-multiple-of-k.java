class Solution {
    public int missingMultiple(int[] nums, int k) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for(int ele : nums) set.add(ele);
        int i = 0;
        int num = k;
        while(i <= n){
            if(!set.contains(num)) return num;
            num += k;
            i++;
        }
        return 0;
    }
    
    
}