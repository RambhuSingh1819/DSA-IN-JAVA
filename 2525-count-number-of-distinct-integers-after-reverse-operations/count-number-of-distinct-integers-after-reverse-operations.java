class Solution {
    public int countDistinctIntegers(int[] nums) {
        if(nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for(int ele : nums) {
            set.add(ele);
            if(ele < 10) continue;
            else set.add(reverse(ele));
        }
        return set.size();
    }
    public int reverse(int num){
        int rev = 0;
        while(num != 0){
            int digit = num % 10;
            rev = rev * 10 + digit;
            num /= 10;
        }
        return rev;
    }
}