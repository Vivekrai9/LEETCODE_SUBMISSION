class Solution {
    public long maxTaxiEarnings(int n, int[][] rides) {
        Arrays.sort(rides, (a,b) -> a[0] - b[0]);

        long []dp = new long[rides.length];
        Arrays.fill(dp, -1);

        int m=rides.length;


        int [] start= new int[m];
        for(int i=0;i<m;i++){
            start[i]=rides[i][0];
        }

        return solve(0,rides,start,dp);
        
    }

    public long solve(int idx, int [][]rides, int [] start,long[]dp){
        if( idx >= rides.length) return 0;

        if(dp[idx] != -1) return dp[idx];

        int next=binary(start ,idx+1, rides[idx][1]);
        long notpick= solve(idx+1,rides,start,dp);


        long earning = rides[idx][1] - rides[idx][0] + rides[idx][2];
        long pick = earning + solve(next ,rides, start,dp );

        return dp[idx] = Math.max(pick , notpick);
    }

    private int binary(int[] arr,int l, int target) {
        int r = arr.length-1;
        int ans = arr.length;
        while(l <= r) {
            int mid = (l + r) / 2;
            if(arr[mid] < target){

            l = mid + 1;
            }
            else{
                ans=mid;
                r = mid-1;
            }
        }
        return ans;
    }
}