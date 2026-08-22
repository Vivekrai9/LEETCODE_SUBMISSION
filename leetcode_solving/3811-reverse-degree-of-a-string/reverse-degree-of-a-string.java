class Solution {
    public int reverseDegree(String s) {

        int sum=0;
        int n=s.length();

        for(int i=0;i<n;i++){
            int reverseInt = 26 - (s.charAt(i) - 'a');
            int index =(i+1);
            
            sum+= reverseInt* index;
        }

        return sum;
        
    }
}