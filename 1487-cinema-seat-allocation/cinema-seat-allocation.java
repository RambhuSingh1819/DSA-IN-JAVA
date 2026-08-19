import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        // Map to store row number -> bitmask of blocked zones
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];
            
            int bitmask = map.getOrDefault(row, 0);
            
            // If seat falls in Left block (2,3,4,5), set 1st bit
            if (col >= 2 && col <= 5) bitmask |= 1; 
            // If seat falls in Right block (6,7,8,9), set 2nd bit
            if (col >= 6 && col <= 9) bitmask |= 2; 
            // If seat falls in Middle block (4,5,6,7), set 3rd bit
            if (col >= 4 && col <= 7) bitmask |= 4; 
            
            map.put(row, bitmask);
        }
        
        // Start by assuming all completely empty rows fit 2 families
        int ans = (n - map.size()) * 2;
        
        // Calculate max families for rows that have at least one reservation
        for (int bitmask : map.values()) {
            if ((bitmask & 3) == 0) { 
                // Both Left (1) and Right (2) are clear. (3 is 011 in binary)
                ans += 2;
            } else if ((bitmask & 1) == 0) { 
                // Only Left is clear
                ans += 1;
            } else if ((bitmask & 2) == 0) { 
                // Only Right is clear
                ans += 1;
            } else if ((bitmask & 4) == 0) { 
                // Only Middle is clear
                ans += 1;
            }
        }
        
        return ans;
    }
}