class Solution {
    public int uniqueXorTriplets(int[] nums) {
        final int MAX = 2048; 
        boolean[] pairXor = new boolean[MAX];

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                pairXor[nums[i] ^ nums[j]] = true;
            }
        }
        boolean[] tripletXor = new boolean[MAX];

        for (int x = 0; x < MAX; x++) {
            if (!pairXor[x]) continue;

            for (int num : nums) {
                tripletXor[x ^ num] = true;
            }
        }

        int count = 0;
        for (boolean b : tripletXor) {
            if (b) count++;
        }

        return count;
    }
}