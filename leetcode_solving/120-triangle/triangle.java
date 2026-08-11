class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = triangle.get(n - 1).get(i);
        }

        for (int r = n-2; r >= 0; r--) {
            for (int c = 0; c <= r; c++) {
                dp[c] = Math.min(dp[c], dp[c+1]) + triangle.get(r).get(c);
            }
        }

        return dp[0];        
    }
}