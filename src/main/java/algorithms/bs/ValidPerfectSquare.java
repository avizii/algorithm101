package algorithms.bs;

/**
 * @Author : Avizii
 * @Create : 2021.01.21
 * @CN-URL : https://leetcode-cn.com/problems/valid-perfect-square
 * @EN-URL : https://leetcode.com/problems/valid-perfect-square/discuss/?currentPage=1&orderBy=most_votes&query=&tag=java
 * @Solve1 : https://leetcode-cn.com/problems/valid-perfect-square/solution/you-xiao-de-wan-quan-ping-fang-shu-by-leetcode/
 * @Solve2 :
 * @Solve3 :
 */
public class ValidPerfectSquare {

    public boolean isPerfectSquare(int num) {
        long l = 0, r = num;
        while (l <= r) {
            long m = l + ((r - l) >> 1);
            long value = m * m;
            if (value == num) return true;
            if (value < num) l = m + 1;
            else r = m - 1;
        }
        return false;
    }

}
