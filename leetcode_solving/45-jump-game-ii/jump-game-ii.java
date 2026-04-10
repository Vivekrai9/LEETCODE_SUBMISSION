class Solution {
    public int jump(int[] nums) {
        int []dp = new int[nums.length +1];
        Arrays.fill(dp , -1);

        return solve(0,nums,dp);

    }

    public int solve(int i, int [] nums,int [] dp){

        int n=nums.length;
        if(i >= n-1) return 0; 

        if(dp[i] != -1) return dp[i];
        
        int res=0;
        int minjump = Integer.MAX_VALUE;

        
        
        for(int j=1;j<=nums[i];j++){
            if(i+j  < n ){
                res = solve(i+j ,nums,dp);
            }

            if(res != Integer.MAX_VALUE){
                minjump= Math.min(minjump , 1+ solve(i+j ,nums,dp));
            }

        }

        return dp[i]= minjump;
        
    }
}