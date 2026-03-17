class Solution {
    public int rob(int[] nums) {

        int []dp = new int[nums.length];
        Arrays.fill(dp , -1);
        
        return robbery(0,nums,dp);

    }

    public int robbery(int i, int [] nums, int[] dp){

        if(i>= nums.length ) return 0;
        if(dp[i] != -1) return dp[i];


        int pick = nums[i]+ robbery(i+2 , nums, dp);
        int notpick = robbery(i+1, nums,dp);

        return dp[i]=Math.max(pick ,notpick);

    }
    }