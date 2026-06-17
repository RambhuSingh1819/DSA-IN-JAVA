class Solution {
    public List<Integer> getRow(int rowIndex) {

        List<Integer> ans = new ArrayList<>();

        long res = 1;
        ans.add(1);

        for(int col = 1; col <= rowIndex; col++) {
            res = res * (rowIndex - col + 1);
            res = res / col;

            ans.add((int)res);
        }

        return ans;
    }
}