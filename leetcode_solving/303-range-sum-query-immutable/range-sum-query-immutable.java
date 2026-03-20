class NumArray {
    int [] tree;
    int n;

    public NumArray(int[] nums) {
        n=nums.length;
        tree = new int[4*n];
        build(nums,0,0,n-1);
        
    }

    public void build(int [] nums,int node , int start , int end){
        if(start == end){
            tree[node]=nums[start];
            return;
        }  
        int mid=start +(end - start)/2;

        build(nums,2*node +1,start,mid);
        build(nums,2*node +2,mid+1,end);
        tree[node] = tree[2*node+1] + tree[2*node+2] ;
    }
    
    public int sumRange(int left, int right) {
        return sumRange(0,0,n-1,left,right);
    }

    public int sumRange(int node, int start , int end , int left , int right){
         // No overlap
        if (right < start || end < left) return 0;

        // Complete overlap
        if (left <= start && end <= right) return tree[node];

        // Partial overlap
        int mid = (start + end) / 2;

        int left_N = sumRange(2 * node + 1, start, mid, left, right);
        int right_N = sumRange(2 * node + 2, mid + 1, end, left, right);

        return left_N + right_N ;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */