package easy.search2DMatrix;

/**
 * use binary search twice.
 */
public class Solution {
    /**
     * @param matrix: matrix, a list of lists of integers
     * @param target: An integer
     * @return: a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
        int left = 0;
        int right = matrix.length - 1;
        int middle = 0;

        if (matrix.length == 0 || matrix == null) {
            return false;
        }

        while (left <= right) {
            middle = (left + right) / 2;
            if (matrix[middle][matrix[middle].length - 1] < target)
                left = middle + 1;
            else if (matrix[middle][0] > target)
                right = middle - 1;
            else
                break;
        }

        int row = middle;
        left = 0;
        right = matrix[middle].length - 1;
        while (left <= right) {
            middle = (left + right) / 2;
            if (left == right && left == middle && matrix[row][middle] != target)
                return false;

            if (matrix[row][middle] == target)
                return true;
            else if (matrix[row][middle] < target)
                left = middle + 1;
            else
                right = middle - 1;
        }

        return false;
    }
}
