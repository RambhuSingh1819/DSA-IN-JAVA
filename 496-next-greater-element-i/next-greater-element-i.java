class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if(n1 < 1 || n2 < 0) return new int[]{};
        HashMap<Integer,Integer> map = new HashMap<>();
        Stack<Integer> stk = new Stack<>();
        for(int i = n2-1; i >= 0 ; i--){
            while(!stk.isEmpty() && stk.peek() < nums2[i]) stk.pop();
            int data = stk.isEmpty() ? -1 : stk.peek();
            map.put(nums2[i],data);
            stk.push(nums2[i]);
        }
        int[] res = new int[n1];
        for(int i = 0; i < n1; i++){
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
}