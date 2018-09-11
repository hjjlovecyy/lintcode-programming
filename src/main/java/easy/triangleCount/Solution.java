package easy.triangleCount;

import java.util.Arrays;

/**
 * Use two pointers to point left and right, both two
 * pointers is in front of present value.
 */
public class Solution {
    /**
     * @param S: A list of integers
     * @return: An integer
     */
    public int triangleCount(int[] S) {
        // write your code here
        Arrays.sort(S);
        int result = 0;

        for (int i = 0; i < S.length; i++) {
            int left = 0;
            int right = i - 1;
            while (left < right) {
                if (S[left] + S[right] > S[i]) {
                    result += right - left;
                    right--;
                } else {
                    left++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = {3, 4, 6, 7};
        System.out.println(new Solution().triangleCount(array));
    }
}
