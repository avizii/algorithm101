package algorithms.bs;

/**
 * @Author : Avizii
 * @Create : 2021.03.11
 *
 * 快速幂算法 : https://zhuanlan.zhihu.com/p/95902286
 * https://leetcode-cn.com/problems/powx-n/solution/powx-n-by-leetcode-solution/
 * https://leetcode-cn.com/problems/powx-n/
 * https://leetcode.com/problems/powx-n/discuss/19546/Short-and-easy-to-understand-solution  @See DyXrLxSTAOadoD
 */
public class PowXN {

    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n == Integer.MIN_VALUE) { // TODO 由于入参是int类型，leetcode有测试用例为-2147483648，int溢出，因此先手动进行一次操作在往下递归
            x *= x;
            n = n / 2;
        }
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        return n % 2 == 0 ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }

}
