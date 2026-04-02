class Solution {
    public int longestPalindromicSubsequence(String s, int k) {

        int n=s.length();

        int [][][] dp = new int[n][n][k + 1];

        for (int[][] layer : dp) {
            for (int[] r : layer) {
                Arrays.fill(r, -1);
            }
        }


        return solve(0,s.length() -1,k,s,dp);
        
    }


    public static int solve( int i, int j , int k , String s,int [][][]dp){
        int res=0;


        if(i > j) return 0;
        if(i==j) return 1;

        if(dp[i][j][k] != -1) return dp[i][j][k];

        if(s.charAt(i)==s.charAt(j)){
            res = Math.max(res, 2 + solve(i+1,j-1,k,s,dp));
        }

        else{
            int fd= Math.abs(s.charAt(i) - s.charAt(j));
            int back = 26-fd;

            int cost= Math.min(fd , back);


            if(k >= Math.min(fd , back)){
                res = Math.max(res, 2 + solve(i+1,j-1,k - cost ,s,dp));

            }
        }

        res = Math.max(res, solve(i+1,j,k,s,dp));
        res = Math.max(res, solve(i,j-1,k,s,dp));



        return dp[i][j][k]  = res;
    }
}