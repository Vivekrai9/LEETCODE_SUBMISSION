class Solution {
    public void rotate(int[][] matrix) {
        int n=matrix[0].length;

        transpose(matrix ,n,n);

        for(int i=0;i<n;i++){
            reverse(matrix[i]);
        }
        
    }

    public void transpose(int [][] matrix , int r1 , int c1){

        for(int i=0;i < r1; i++){
            for(int j=i+1;j < c1 ; j++){
                int temp = matrix[i][j];
                matrix[i][j]= matrix[j][i];
                matrix[j][i] = temp ;
            }
        }
    }

    public void reverse(int [] arr){
        int i=0 , j= arr.length -1;
        while(i < j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;

        }
    }


}