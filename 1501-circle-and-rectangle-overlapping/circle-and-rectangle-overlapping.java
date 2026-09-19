class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        // Find the closest x and y coordinates on the rectangle to the circle center
        int closestX = Math.max(x1, Math.min(xCenter, x2));
        int closestY = Math.max(y1, Math.min(yCenter, y2));
        
        // Calculate the distance from the closest point to the circle center
        int distX = xCenter - closestX;
        int distY = yCenter - closestY;
        
        // Check if the distance is less than or equal to the radius
        return (distX * distX + distY * distY) <= (long) radius * radius;
    }
}