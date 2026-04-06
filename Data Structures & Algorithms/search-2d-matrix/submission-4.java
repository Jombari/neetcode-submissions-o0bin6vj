class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int z = 0;
        while(z < m && matrix[z][n-1] < target){
            z++;
        }
        if(z >= m)
            return false;
        return binarySearch(matrix[z],target);
    }

    private boolean binarySearch(int[] row, int target){
        int left = 0;
        int right = row.length-1;
        while(left<=right){
            int mid = left + (right-left/2);
            if(target == row[mid])
                return true;
            if(target > row[mid]){
                left = mid+1;
            } else if(target < row[mid]){
                right = mid -1;
            }
        }
        return false;
    }
}
