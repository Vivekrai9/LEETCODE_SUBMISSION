class Solution {
    public int minPathSum(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        for (int[] row : dp)
            Arrays.fill(row, -1);

        return solve(0, 0, grid, dp);

    }

    public int solve(int i, int j, int[][] grid, int dp[][]) {

        if (i == grid.length - 1 && j == grid[0].length - 1)
            return grid[i][j];

        if (i >= grid.length || j >= grid[0].length)
            return Integer.MAX_VALUE;

        if (dp[i][j] != -1) return dp[i][j];

        int down = solve(i, j + 1, grid, dp);
        int right = solve(i + 1, j, grid, dp);

        int cost = grid[i][j] + Math.min(down, right);

        return dp[i][j] = cost;

    }
}