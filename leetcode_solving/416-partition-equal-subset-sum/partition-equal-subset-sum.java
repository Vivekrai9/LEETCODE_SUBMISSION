class Solution {
    public boolean canPartition(int[] nums) {

        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        // int target=0;
        if(sum%2 ==0 ){
            sum = sum/2;
        }
        else{
            return false;
        }


        Boolean [][]dp = new Boolean[nums.length+1][sum+1];

        return solve(0,sum, nums,dp);  
    }

    public boolean solve(int i,int target , int[] nums, Boolean [][]dp){

        if(target==0) return true;
        if(i == nums.length) return false;

        if(dp[i][target] != null ) return dp[i][target];

        boolean pick = false;
        if(nums[i]<= target){
            pick = solve(i+1, target - nums[i], nums,dp);
        }

        boolean notpick = solve(i+1,target, nums,dp);

        return dp[i][target]= pick || notpick;

    }
}