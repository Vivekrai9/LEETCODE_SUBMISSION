class Solution {
    public int lengthOfLIS(int[] nums) {

        int ans = Integer.MIN_VALUE;

        int []dp = new int[2505];
        Arrays.fill(dp ,-1);

        for (int i = 0; i < nums.length; i++) {
            ans = Math.max(ans, solve(ans, i, nums,dp));
        }

        return ans;
    }

    public int solve(int an, int i, int[] nums,int []dp) {

        if (i == nums.length) return 0;
        int ans = 1;

        if(dp[i]!= -1) return dp[i];

        for (int j = 0; j < i; j++) {
            if (nums[j] < nums[i]) {
                ans = Math.max(ans, solve(an, j, nums,dp) + 1);
            }
        }

        return dp[i]=ans;
    }
}