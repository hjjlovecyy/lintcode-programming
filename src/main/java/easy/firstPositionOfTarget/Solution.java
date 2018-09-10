package easy.firstPositionOfTarget;

/**
 * Created by hejiajun
 * On 2018/9/10
 */
public class Solution {
    /**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public int binarySearch(int[] nums, int target) {
        // write your code here
        int left = 0;
        int right = nums.length - 1;
        int middle = 0;

        if (0 >= nums.length) {
            return -1;
        }

        while (left <= right) {
            middle = (left + right) / 2;

            // target does not exist in the array
            if ((left == right) && (left == middle) && (nums[middle] != target))
                return -1;

            if (nums[middle] > target)
                right = middle - 1;
            else if (nums[middle] < target)
                left = middle + 1;
            else if (nums[middle] == target)
                break;
        }

        // idx=0, return
        while (middle == 0) {
            return middle;
        }

        while (nums[middle] == nums[middle - 1]) {
            middle--;
            // idx=0, return
            if (middle == 0) {
                return middle;
            }
        }

        return middle;
    }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3, 3, 4, 5, 10};
        System.out.println(solution.binarySearch(nums, 3));
    }
}
