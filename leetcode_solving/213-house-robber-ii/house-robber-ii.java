class Solution {
    public int rob(int[] nums) {
        int [] dp1 = new int[nums.length+1];
        int [] dp2 = new int[nums.length+1];

        Arrays.fill(dp1 ,-1);
        Arrays.fill(dp2, -1);

        

        if(nums.length==1){
            return nums[0];
        }
        int case1=robbery(0,nums.length-2,nums,dp1);
        int case2=robbery(1,nums.length-1,nums,dp2);

        return Math.max(case1 , case2);

        
    }

    public int robbery( int i,int end, int []nums, int[]dp){
        if(i > end) return 0;

        if(dp[i] != -1) return dp[i];
        
        int pick = nums[i] + robbery(i+2,end, nums,dp);
        int notpick = robbery(i+1,end,nums,dp);

        return dp[i] = Math.max(pick ,notpick);
    }


}