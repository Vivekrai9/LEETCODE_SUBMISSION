class Solution {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int n= piles.size();

        int [][]dp = new int[n+1][k+1];

        for(int []r : dp){
            Arrays.fill(r, -1);
        }

        return solve(0,k,n,piles,dp);

        
    }

    public int solve(int i, int k,int n, List<List<Integer>> piles ,int [][]dp ){

        if(i>= n || k==0) return 0;
        int ans=0;
        int sum=0;

        if(dp[i][k] != -1) return dp[i][k];

        ans=Math.max(ans , solve(i+1, k,n, piles,dp));

        for(int j=0; j < piles.get(i).size(); j++){
            sum += piles.get(i).get(j);

            if(k>= j+1){
            int lev = sum + solve(i+1,k-j-1,n,piles,dp);
            ans= Math.max(ans, lev);
            }
        }

        return dp[i][k] = ans;

    }
}