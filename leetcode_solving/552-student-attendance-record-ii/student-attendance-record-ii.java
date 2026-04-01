class Solution {

    long MOD = 1_000_000_007;
    public int checkRecord(int n) {
        int dp[][][] = new int[n+1][2][3];

        for (int i = 1; i < n+1; i++) {
            for (int a = 0; a < 2; a++) {
                for (int l = 0; l < 3; l++) {
                    dp[i][a][l] = -1;
                }
            }
        }

        return solve(1,n,0,0,dp);

        
    }

    public int solve(int i, int n, int ab_count , int L_count,int dp[][][]){
        if (ab_count > 1 || L_count > 2) return 0;
        if(i > n) return 1;


        if(dp[i][ab_count][L_count] !=-1 ) return dp[i][ab_count][L_count];

        //present
        long c1=0;
        c1 = solve(i+1,n,ab_count,0,dp);

        //absent
        long c2=0;
        if(ab_count == 0){
        c2= solve(i+1,n,ab_count+1,0,dp);
        }
        
        //Late
        long c3=0;
        if(L_count < 2) {
            c3= solve(i+1,n,ab_count,L_count+1,dp);
        }

        

        dp[i][ab_count][L_count] = (int)((c1 + c2 + c3) % MOD);
        return dp[i][ab_count][L_count];


    }
}