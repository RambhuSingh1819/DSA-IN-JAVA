class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        if(target == 'z') return letters[0];
        int n = letters.length;
        int low = 0;
        int high = n-1;
        if(target < letters[0]) return letters[0];
        while(low <= high){
            int mid = low + (high-low)/2;
            if(letters[mid] <= target) low = mid + 1;
            else high = mid - 1;
        }
        return letters[low%n];
    }
}