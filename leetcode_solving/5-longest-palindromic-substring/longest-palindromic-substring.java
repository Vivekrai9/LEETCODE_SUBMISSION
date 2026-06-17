class Solution {
    public String longestPalindrome(String s) {

        int maxlen = Integer.MIN_VALUE;
        int sp=0;

        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                if(solve(s,i,j)== true){

        
                int len= j-i+1;
                if(len > maxlen){
                    maxlen = len;
                    sp=i;
                }
            }
        }
        }
        

        return s.substring(sp ,sp + maxlen);
    }


    boolean solve(String s, int i , int j){
        if(i>=j) return true;

        if(s.charAt(i) == s.charAt(j))
            return solve(s,i+1,j-1);

        return false;
    }
}