package easy.reverse3digitInteger;

/**
 * first convert  to String, and then reverse.
 */
public class Solution {
    public static void main(String[] args) {
        int number = 900;
        System.out.println(new Solution().reverseInteger(number));
    }

    /**
     * @param number: A 3-digit number.
     * @return: Reversed number.
     */
    public int reverseInteger(int number) {
        // write your code here
        String num2Str = String.valueOf(number);
        String result = "";

        for (int i =  2; i >= 0; i--) {
            result += num2Str.charAt(i);
        }

        return Integer.parseInt(result);
    }
}
