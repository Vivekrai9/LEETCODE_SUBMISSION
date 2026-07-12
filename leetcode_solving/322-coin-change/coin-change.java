class Solution {
    public int coinChange(int[] coins, int amount) {

        int [][] dp = new int[coins.length +1 ][amount +1];
        for(int[]r : dp){
            Arrays.fill(r,-2);
        }

     int ans = solve(0,coins ,amount,dp);

     return ans == Integer.MAX_VALUE ? -1 : ans;
        
    }


    public int solve(int i, int [] coins, int remaining, int[][]dp){
        if(i >= coins.length ) return Integer.MAX_VALUE;

        if(remaining == 0  ) return 0;

        if(dp[i][remaining] != -2) return dp[i][remaining];

        int take= Integer.MAX_VALUE;
         if(coins[i] <= remaining){
            take = solve(i,coins,remaining - coins[i],dp);

            if(take != Integer.MAX_VALUE){
                take++;
            }
         }

        int skip = solve(i+1,coins,remaining,dp);

        return dp[i][remaining]= Math.min(take , skip) ;
    }
}