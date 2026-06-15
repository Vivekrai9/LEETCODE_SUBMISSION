import java.util.*;

class Solution {
    public void nextPermutation(int[] nums) {
        int n= nums.length;

        int gola_index = -1;

        for(int i=n-1;i>0 ;i--){
            if(nums[i-1] < nums[i]){
                gola_index = i-1;
                break;
            }
        }

        if(gola_index != -1){
            int swap_index = gola_index;
            for(int j=n-1; j >= gola_index+1 ;j--){
                if(nums[j] > nums[gola_index]){
                    swap_index = j;
                    break;
                }
            }
            swap(gola_index , swap_index, nums);
        }

        reverse(nums , gola_index+1 , n-1);

    }


    public void swap(int i , int j , int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp ;

    }

    public void reverse(int [] nums, int start , int end ){
        while(start < end){
            swap(start ,end, nums);
            start++;
            end--;
        }
    }




}