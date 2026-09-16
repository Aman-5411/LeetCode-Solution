class Solution {
    int[] dir = new int[]{0, 1, 0}; //right --> down

    private boolean isValid(int[][] grid, int r, int c) {
        int m = grid.length, n = grid[0].length;
        
        if(r < 0 || c < 0 || r >= m || c >= n)
            return false;

        return true;
    }

    private int dfs(int[][] grid, int r, int c, Integer[][] memo){   
        int m = grid.length, n = grid[0].length;
        if(r == m - 1 && c == n - 1) {
            return grid[r][c];
        }

        if(memo[r][c] != null)
            return memo[r][c];

        int best  = Integer.MAX_VALUE;
        for(int i = 0; i < dir.length - 1; i++) {
            int nr = r + dir[i];
            int nc = c + dir[i + 1];

            if(isValid(grid, nr, nc)){
                int next = dfs(grid, nr, nc, memo);
                best = Math.min(best, next);
            }
        }
        int res = grid[r][c] + best;
        memo[r][c] = res;
        return res;
    }
    public int minPathSum(int[][] grid) {
        int sum = 0;
        int m = grid.length, n = grid[0].length;      
        Integer[][] memo = new Integer[m][n];
        
        return dfs(grid, 0, 0, memo);
    }
}