package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author : Avizii
 * @Create : 2021.03.19
 *
 * https://leetcode-cn.com/problems/find-all-anagrams-in-a-string
 * https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/solution/438-zhao-dao-zi-fu-chuan-zhong-suo-you-z-nx6b/
 */
public class FindAllAnagramsInAString {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s.length() < p.length()) return res;

        // 记录p的所有字母及其个数
        int[] need = new int[26];
        for (int i = 0; i < p.length(); i++) {
            need[p.charAt(i) - 'a']++;
        }

        // 定义滑动窗口存储空间 滑动窗口的开始和结束index
        int[] window = new int[26];
        int start = 0, end = 0;
        while (end < s.length()) {
            window[s.charAt(end) - 'a']++; // 加入窗口数据
            // 当滑动窗口大小与need大小相同时比较两个数组是否相等
            while (end - start + 1 == p.length()) {
                // 两个数据相等 => 找到一组异位词
                if (Arrays.equals(need, window)) res.add(start);
                // 弹出滑动窗口最左边的元素，滑动窗口右滑，寻找是否存在下一个异位词
                window[s.charAt(start) - 'a']--;
                start++;
            }
            end++;
        }
        return res;
    }

    public static void main(String[] args) {
//        char[] a = {'a', 'b', 'c'};
//        char[] b = {'b', 'a', 'c'};
//        char[] c = {'a', 'c', 'd'};
        System.out.println(Arrays.equals(new int[]{1, 2, 3}, new int[]{1, 2, 3}));
        System.out.println(Arrays.equals(new int[]{1, 2, 3}, new int[]{1, 3, 2}));

        char[] d = new char[1];
        d[0]++;
        System.out.println(d);
    }
}
