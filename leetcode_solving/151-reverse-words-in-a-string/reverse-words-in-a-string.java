class Solution {
    public String reverseWords(String s) {
        // String[] str = s.split(" ");
        String[] str = s.trim().split("\\s+");
        int left = 0;
        int right = str.length - 1;

        while (left < right) {
            String temp = str[left];
            str[left] = str[right];
            str[right] = temp;
            left++;
            right--;
        }

        // StringBuilder res = new StringBuilder();

        // for(String word : str){
        //     if(! word.isEmpty()){

        //         if(res.length() > 0){
        //             res.append(" ");
        //         }


        //         res.append(word);

        //     }
        // }


        // return res.toString();    


        return String.join(" ", str);   
    }
}