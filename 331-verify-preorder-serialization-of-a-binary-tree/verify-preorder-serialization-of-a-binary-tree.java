class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        int cnt = 1;
        for (String node : nodes) {
            cnt--;
            if (cnt < 0) return false;
            if (!node.equals("#")) cnt += 2;
        }   
        return cnt == 0;  
    }
}