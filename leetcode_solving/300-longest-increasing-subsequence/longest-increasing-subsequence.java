class Solution {

    public int f(int i, int prev , int[][]dp , int [] nums){
        if(i >= nums.length){
            return 0;
        }
        if(dp[i][prev+1] != -1){
            return dp[i][prev+1];
        }

        int pick=0, not_pick=0;

        if(prev == -1 || nums[i] > nums[prev]){
            pick = 1 + f(i+1,i,dp,nums);
        }

        not_pick = f(i+1,prev,dp,nums);

        return dp[i][prev+1]= Math.max(pick , not_pick);

    }
    public int lengthOfLIS(int[] nums) {
        int n= nums.length;
        int[][]dp = new int[n][n+1];

        for(int i=0;i<n;i++){
            Arrays.fill(dp[i], -1);
        }

        return f(0, -1, dp , nums);


        
    }
}

