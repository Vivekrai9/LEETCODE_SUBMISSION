class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        Boolean dp[] = new Boolean[s.length()];
        return solve(0,s,set,dp);
    }


    public boolean solve( int i, String s,Set<String> dict,Boolean dp[]){
        if(i == s.length()){
            return true;

        }

        if(dp[i] != null) return dp[i];

        if(dict.contains(s)){
            return true;
        }

        for(int l=i+1; l<=s.length();l++){
            String temp = s.substring(i,l);

            if(dict.contains(temp) && solve(l , s,dict,dp))
                return dp[i]= true;
        }


        return dp[i]= false;
    }

    
}