class Solution {
    public int maxProduct(int[] nums) {
        int res = Integer.MIN_VALUE;
        for (int n : nums) {
            res = Math.max(res, n);
        }

        int curMax = 1, curMin = 1;

        for (int n : nums) {
            int maxe = curMax * n;
            curMax = Math.max(maxe, Math.max(curMin * n, n));
            curMin = Math.min(maxe, Math.min(curMin * n, n));

            res = Math.max(res, curMax);
        }

        return res;        
    }
}