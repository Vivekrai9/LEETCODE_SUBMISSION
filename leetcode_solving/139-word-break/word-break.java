import java.util.*;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> st = new HashSet<>(wordDict);

        int n= s.length();
        Boolean [] dp = new Boolean[n];

        // Arrays.fill(dp , false);

        return solve(0,s,st,n,dp);
    }

    public boolean solve(int i,String s, Set<String> st, int n, Boolean [] dp){
        if(i == n ) return true;

        StringBuilder sb = new StringBuilder();

        if(dp[i] != null) return dp[i];

        for(int j=i;j<n;j++){
            sb.append(s.charAt(j));
            
            if(st.contains(sb.toString()) ){
                if(solve(j+1,s,st,n,dp)){
                    return dp[i]=true;
                }
            }
        }

        return dp[i]=false;
    }
}