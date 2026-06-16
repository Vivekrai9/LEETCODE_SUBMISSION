class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxPro = 0;

        for(int x: prices){
            minPrice = Math.min(minPrice , x);
            maxPro= Math.max(maxPro , x - minPrice);

        }

       return maxPro;
    }
}