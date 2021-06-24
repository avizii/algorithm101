package stack;

/**
 * @Author : Avizii
 * @Create : 2021.01.15
 * @CN-URL : https://leetcode-cn.com/problems/plus-one
 * @EN-URL : https://leetcode.com/problems/plus-one/discuss/?currentPage=1&orderBy=most_votes&query=&tag=java
 * @Solve1 : https://leetcode-cn.com/problems/plus-one/solution/java-shu-xue-jie-ti-by-yhhzw/
 * @Solve2 :
 * @Solve3 :
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] %= 10;
            if (digits[i] != 0) return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

}
