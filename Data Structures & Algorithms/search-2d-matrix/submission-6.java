class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int bottom = matrix.length-1;
        int top = 0;
        while(top <= bottom){
            int mid = top + (bottom-top)/2;
            if(target >= matrix[mid][0] && target <= matrix[mid][matrix[mid].length-1])
                return binarySearch(matrix[mid],target);
            if(matrix[mid][0] > target){
                bottom = mid-1;
            } else if(matrix[mid][0] < target){
                top = mid+1;
            }
        }
        return false;
    }

    private boolean binarySearch(int[] row, int target){
        int left = 0;
        int right = row.length-1;
        while(left<=right){
            int mid = left + (right-left)/2;
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