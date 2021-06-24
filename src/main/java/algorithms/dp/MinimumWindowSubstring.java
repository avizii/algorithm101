package algorithms.dp;

/**
 * @Author : Avizii
 * @Create : 2021.03.18
 *
 * https://leetcode-cn.com/problems/minimum-window-substring
 * https://leetcode-cn.com/problems/minimum-window-substring/solution/tong-su-qie-xiang-xi-de-miao-shu-hua-dong-chuang-k/
 */
public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0) return "";

        //记录需要的字符的个数
        // ASIIC码 128位
        int[] need = new int[128];
        for (int i = 0; i < t.length(); i++) {
            need[t.charAt(i)]++;
        }

        // l 左边界 、  r 右边界 、 count 记录需求个数，避免遍历need数组
        int l = 0, r = 0, count = t.length();

        // size 最终窗口大小 、 start 最终窗口开始index
        int size = Integer.MAX_VALUE, start = 0;

        // 遍历所有字符
        while (r < s.length()) {
            char c = s.charAt(r);
            if (need[c] > 0) { // 需要字符c
                count--;
            }
            need[c]--;  // need 数组移除一个字符c

            if (count == 0) { // 窗口中已包含全部字符

                // 移除左边无用字符，直到遇到所需要用的字符
                while (l < r && need[s.charAt(l)] < 0) {
                    need[s.charAt(l)]++;
                    l++; // 窗口右移
                }

                // 更新 窗口大小 和 开始index
                if (size > r - l + 1) {
                    size = r - l + 1;
                    start = l;
                }

                // 窗口继续右移1个字符，重新开始循环，查找可能存在的更小子串
                need[s.charAt(l)]++;
                l++;
                count++;
            }
            r++;  // 把右边的字符加入到窗口

        }

        return size == Integer.MAX_VALUE ? "" : s.substring(start, start + size);
    }


    public String solve1(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0) {
            return "";
        }

        char[] need = new char[128];
        for (int i = 0; i < t.length(); i++) {
            need[t.charAt(i)]++;
        }

        int l = 0, r = 0, count = t.length();
        int size = Integer.MAX_VALUE, start = 0;

        while (r < s.length()) {
            char c = s.charAt(r);
            if (need[c] > 0) count--;
            need[c]--;
            if (count == 0) {
                while (l < r && need[s.charAt(l)] < 0) {
                    need[s.charAt(l)]++;
                    l++;
                }

                if (size > r - l + 1) {
                    size = r - l + 1;
                    start = l;
                }

                need[s.charAt(l)]++;
                l++;
                count++;
            }
            r++;
        }
        return size == Integer.MAX_VALUE ? "" : s.substring(start, start + size);
    }

    public String solve2(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0) return "";
        char[] need = new char[128];
        for (int i = 0; i < t.length(); i++) need[t.charAt(i)]++;
        int l = 0, r = 0, count = t.length();
        int start = 0, size = Integer.MAX_VALUE;
        while (r < s.length()) {
            char c = s.charAt(r);
            if (need[c] > 0) count--;
            need[c]--;
            if (count == 0) {
                while (l < r && need[t.charAt(l)] < 0) {
                    need[t.charAt(l)]++;
                    l++;
                }
                if (size > r - l + 1) {
                    size = r - l + 1;
                    start = l;
                }
                need[t.charAt(l)]++;
                l++;
                count++;
            }
            r++;
        }
        return size == Integer.MAX_VALUE ? "" : s.substring(start, start + size);
    }

}
