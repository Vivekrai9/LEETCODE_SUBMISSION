class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();

        solve(0,nums,subset,ans);

        return ans;
    }

    public void solve( int i , int []nums, List<Integer> subset , List<List<Integer>> ans){

        if(i == nums.length){
            ans.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[i]);
        solve(i+1,nums,subset,ans);

        subset.remove(subset.size()-1);

        while(i+1 < nums.length && nums[i] == nums[i+1]){
            i++;
        } //imp condition for nottake
        solve(i+1,nums,subset,ans);
    }
}