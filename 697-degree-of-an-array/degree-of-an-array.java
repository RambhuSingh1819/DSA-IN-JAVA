class Solution {
    public int findShortestSubArray(int[] nums) {

        HashMap<Integer,Integer> freq = new HashMap<>();
        HashMap<Integer,Integer> first = new HashMap<>();
        HashMap<Integer,Integer> last = new HashMap<>();
        
        int maxFreq = 0;

        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            freq.put(num,freq.getOrDefault(num,0)+1);

            if(!first.containsKey(num)){
                first.put(num,i);
            }
            last.put(num,i);

            maxFreq = Math.max(maxFreq,freq.get(num));

        }
        int minLen = nums.length;
        for(int ele : freq.keySet()){
            if(freq.get(ele) == maxFreq){
                minLen = Math.min(minLen,last.get(ele) - first.get(ele) + 1);
            }
        }
        return minLen;
        
    }
}