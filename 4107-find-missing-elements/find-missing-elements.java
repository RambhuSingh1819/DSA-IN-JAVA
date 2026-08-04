class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        boolean[]  visit = new boolean[101]; 

        List<Integer> list = new ArrayList<>();

        for(int ele : nums){
            if(ele < low) low = ele;
            if(ele > high) high = ele;
            visit[ele] = true;
        }
        if(low == high) return list;
        for(int i = low ; i <= high; i++){
            if(!visit[i]) list.add(i);
        }        
        return list;
    }
}