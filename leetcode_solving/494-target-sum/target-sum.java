class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        

        Map<String ,Integer> mp = new HashMap<>();

        return solve(0,target, nums ,mp);
        
    }

    public int solve(int i, int target, int[] nums, Map<String ,Integer> mp){
        

        if(i== nums.length) {
            if(target == 0) return 1;
            else return 0;
        }

        String key = i + "," + target;
        if (mp.containsKey(key)) return mp.get(key);

        int plus= solve(i+1, target + nums[i], nums,mp);
        
        int minus= solve(i+1,target - nums[i] ,nums,mp);

        mp.put(key, plus + minus);
        return mp.get(key);
    }
}




