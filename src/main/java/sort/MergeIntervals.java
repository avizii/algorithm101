package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Author : Wu.D.J
 * @Create : 2021.01.04
 * @Problem : https://leetcode-cn.com/problems/merge-intervals/
 * @Solution : https://leetcode.com/problems/merge-intervals/discuss/21222/A-simple-Java-solution
 */
public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        if (intervals == null || intervals.length == 0) return res.toArray(new int[0][]);
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int start = intervals[0][0], end = intervals[0][1];
        for (int[] i : intervals) {
            if (i[0] <= end) {
                end = Math.max(end, i[1]);
            } else {
                res.add(new int[]{start, end});
                start = i[0];
                end = i[1];
            }
        }
        res.add(new int[]{start, end});
        return res.toArray(new int[0][]);
    }
}
