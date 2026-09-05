class Solution {
    //DFS + BackTrack
    private int[] dir = new int[]{-1, 0, 1, 0, -1}; // Up -> Right -> Down -> Left

    private boolean isValid(int[][] grid, int r, int c, int m, int n) {
        if(r < 0 || c < 0 || r > m - 1 || c > n - 1 || grid[r][c] == 0)     
            return false;

        return true;
    }

    private int dfs(int[][] grid, int r, int c) {
        int m = grid.length;
        int n = grid[0].length;

        int gold = grid[r][c];
        grid[r][c] = 0;
        int currMax = 0;


        for(int i = 0; i < dir.length - 1; i++) {
            int nr = r + dir[i];
            int nc = c + dir[i + 1];

            if(isValid(grid, nr, nc, m, n)){
                currMax = Math.max(currMax, dfs(grid, nr, nc));
            }
        }

        grid[r][c] = gold;
        //currMax =- gold;
        return currMax + gold;
    }

    public int getMaximumGold(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        int currMax = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                
                if(isValid(grid, i, j, m, n)) {
                    ans = Math.max(ans, dfs(grid, i, j));
                }
            }
        }
        return ans;
    }
}