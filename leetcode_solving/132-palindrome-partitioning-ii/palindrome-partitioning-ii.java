class Solution {
    public int minCut(String s) {

        int [] dp = new int[s.length()];
        Arrays.fill(dp,-1);
        

        return solve(0,s, dp) - 1;
        
    }

    public int solve(int i, String s,int []dp ){
        int n= s.length();

        if(i==n) return 0;

        if(dp[i]!= -1) return dp[i];

        

        int ans=Integer.MAX_VALUE;

        for(int j=i;j<n;j++){
            

            if(palindrome(s,i,j)){
                ans= Math.min(ans , 1 + solve(j+1 ,s,dp));

            }
        }

        return dp[i] = ans;

    }


    Boolean palindrome(String st, int i, int j){
        
        while(i<j){
            if(st.charAt(i) != st.charAt(j)){
                return false;
            }
            i++;
            j--;

        }

        return true;
    }
}