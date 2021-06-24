package algorithms.bs;

/**
 * @Author : Avizii
 * @Create : 2021.01.21
 * @CN-URL : https://leetcode-cn.com/problems/sqrtx
 * @EN-URL : https://leetcode.com/problems/sqrtx/discuss/?currentPage=1&orderBy=most_votes&query=&tag=java
 * @Solve1 : https://leetcode-cn.com/problems/sqrtx/solution/x-de-ping-fang-gen-by-leetcode-solution/
 * @Solve2 :
 * @Solve3 :
 */
public class Sqrtx {

    /**
     * 为什么用二分查找？
     *     y = x^2 (x >= 0),  0 < y < x  y轴对称的抛物线，右边部分单调递增
     */
    public int mySqrt(int x) {
        long l = 0, r = x, ans = -1;
        while (l <= r) {
            long m = l + ((r - l) >> 1);
            long val = m * m;
            if (val == x) return (int) m;
            if (val < x) {
                ans = m;  // 当m*m<x时，m的值也先保存下来，防止y开方不是整数的情况导致输出-1
                l = m + 1;
            } else r = m - 1;
        }
        return (int) ans;
    }

}
