import java.util.*;

class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();
        
        int startR = -1, startC = -1;
        int litterCount = 0;
        int[][] litterId = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(litterId[i], -1);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char ch = classroom[i].charAt(j);
                if (ch == 'S') {
                    startR = i;
                    startC = j;
                } else if (ch == 'L') {
                    litterId[i][j] = litterCount++;
                }
            }
        }
        
        // If there is no litter to collect, 0 moves are needed
        if (litterCount == 0) return 0;
        int targetMask = (1 << litterCount) - 1;
        
        // maxEnergy[r][c][mask] stores the highest remaining energy seen at state (r, c, mask)
        int[][][] maxEnergy = new int[m][n][1 << litterCount];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(maxEnergy[i][j], -1);
            }
        }
        
        // Queue elements: [row, col, mask, current_energy, steps]
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{startR, startC, 0, energy, 0});
        maxEnergy[startR][startC][0] = energy;
        
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];
            int mask = curr[2];
            int curEnergy = curr[3];
            int steps = curr[4];
            if (mask == targetMask) {
                return steps;
            }
            if (curEnergy == 0) {
                continue;
            }
            
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (nr < 0 || nr >= m || nc < 0 || nc >= n) continue;
                char cell = classroom[nr].charAt(nc);
                if (cell == 'X') continue;
                int nextEnergy = curEnergy - 1;
                if (cell == 'R') {
                    nextEnergy = energy; 
                }
                int nextMask = mask;
                if (cell == 'L' && litterId[nr][nc] != -1) {
                    nextMask |= (1 << litterId[nr][nc]);
                }
                if (nextEnergy > maxEnergy[nr][nc][nextMask]) {
                    maxEnergy[nr][nc][nextMask] = nextEnergy;
                    queue.offer(new int[]{nr, nc, nextMask, nextEnergy, steps + 1});
                }
            }
        }
        
        return -1;
    }
}