class Solution {        
    int m, n;
    int[][][] memo; // i, j, count;

    private boolean helper(int i, int j, int count, char[][] grid) {
        count += (grid[i][j] =='(') ? 1 : -1;

        if(count < 0)   return false;

        if(memo[i][j][count] != -1) return memo[i][j][count] == 1;

        if(i == m - 1 && j == n - 1){
            memo[i][j][count] = (count == 0) ? 1 : 0;
            return (count == 0);
        }

        boolean ans = false;

        if(i + 1 < m){
            if(helper(i + 1, j, count, grid)) {   
                memo[i][j][count] = 1;
                return true;
            }
        }

        if(j + 1 < n){
            if(helper(i, j + 1, count, grid))  {  
                memo[i][j][count] = 1;
                return true;
            }
        }
        
        memo[i][j][count] = 0;
        return false;
    }

    public boolean hasValidPath(char[][] grid) {
        this.m = grid.length;
        this.n = grid[0].length;

        if((m + n - 1) % 2 == 1)
            return false;

        if(grid[0][0] == ')' || grid[m - 1][n - 1] == '(')
            return false;

        memo = new int[m][n][201];
        for(int[][] row : memo) {
            for(int[] col : row) {
                Arrays.fill(col, -1);
            }
        }
        return helper(0, 0, 0, grid);
    }
}