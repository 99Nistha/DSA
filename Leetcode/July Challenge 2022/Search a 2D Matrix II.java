class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m= matrix.length;
        int n= matrix[0].length;
        int i= 0; // top right
        int j= n-1;
        while(i<m && j>=0){
            int val= matrix[i][j];
            if(target== val) return true;
            else if(val>target){
                j--;
            }else{
                i++;
            }
        }
        return false;
    }
}
