class Solution {
    public boolean detectCapitalUse(String word) {
        int upperCase =0;

        for(int i=0;i< word.length();i++){
            char ch = word.charAt(i);
            if(Character.isUpperCase(ch))
             upperCase++;
        }

        return upperCase == word.length() || upperCase == 0
                || (upperCase == 1 && Character.isUpperCase(word.charAt(0))) ;
        
    }
}