class Solution {
    public int lengthOfLIS(int[] nums) {

        int [][]dp = new int[nums.length+1][nums.length+1];

        for(int [] r: dp){
            Arrays.fill(r,-1);

        }

        return solve(0,-1,nums,dp);
    }

    public int solve(int i, int prev , int [] nums,int [][]dp){
        if(i>= nums.length) return 0;

        if(dp[i][prev+1] != -1) return dp[i][prev+1];


        int pick=0;
        if((prev == -1 ) || nums[i] > nums[prev]){
            pick= 1+ solve(i+1,i, nums,dp);
        } 

        int notpick= solve(i+1,prev, nums,dp);


        return dp[i][prev+1]= Math.max(pick ,notpick);
    }
}