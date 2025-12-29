class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length < 1) return 0;
        
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            set.add(nums[i]);
        }
        int answer = 1;
        for(int num : set){
            if(set.contains(num-1)) continue;
            else {
                int currentNum = num;
                int currentLongSeq = 1;
                while(set.contains(currentNum+1)){
                    currentNum++;
                    currentLongSeq++;
                }
               answer =  Math.max(answer,currentLongSeq);
            }
        }
        return answer;
    }
}