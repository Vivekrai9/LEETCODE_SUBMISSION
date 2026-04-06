class Solution {
    long MOD=1_000_000_007;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int [][][]dp = new int[m+1][n+1][maxMove+1];

        for(int[][] r : dp){
            for(int [] c: r){
            Arrays.fill(c , -1);
            }
        }

        return solve(startRow, startColumn, maxMove , m, n ,dp);
        
    }

    public int solve(int i, int j, int move ,int m, int n, int [][][]dp ){
        if(i < 0 || j <0 || i >= m || j >= n ) return 1;
        if(move== 0) return 0;

        if(dp[i][j][move] != -1) return dp[i][j][move];

        long ans=0;

        //left
        ans= ( ans+ solve( i,  j-1,  move-1 , m,  n ,dp)) % MOD ;

        //right
        ans= (ans+ solve( i, j+1,  move-1 , m,  n ,dp)) % MOD;

        //up
        ans= (ans+ solve(i-1, j, move-1 ,m, n ,dp)) % MOD;

        //down
        ans= (ans+ solve(i+1, j, move-1 ,m, n ,dp))% MOD;

        return dp[i][j][move] = (int) (ans % MOD);

    }
}