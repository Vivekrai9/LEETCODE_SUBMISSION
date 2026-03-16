class Solution {
    static int longestCommonSubsequence(String s1, String s2) {
        int n= s1.length();
        int m=s2.length();

        int[][] dp = new int[n][m];

        for(int []r : dp){
            Arrays.fill(r ,-1);
        }

        return LCS(0,0,s1,s2,dp);
    
}

    public static int LCS(int i, int j, String s1 , String s2 , int [][]dp){
        int n= s1.length();
        int m=s2.length();

        if(i>=n || j>=m) return 0;

        int pick=0, notpick1 = 0 , notpick2 = 0 ;
        if(dp[i][j] != -1) return dp[i][j];

        if(s1.charAt(i)==s2.charAt(j)){
            pick = 1+ LCS(i+1,j+1,s1,s2,dp);
        }

        notpick1= LCS(i+1,j,s1,s2,dp);
        notpick2= LCS(i,j+1,s1,s2,dp);

        // int one= Math.max(pick ,notpick1);
        // return dp[i][j] = Math.max(one, notpick2);

        return dp[i][j] = Math.max(Math.max(pick , notpick1) , notpick2);
    }
}
