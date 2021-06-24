package sort;

import java.util.Map;
import java.util.TreeMap;

/**
 * @Author : Wu.D.J
 * @Create : 2021.01.04
 * @Url : https://leetcode-cn.com/problems/relative-sort-array/
 * @Solution : https://leetcode.com/problems/relative-sort-array/discuss/335056/Java-in-place-solution-using-counting-sort
 */
public class RelativeSortArray {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        // because the constraint [0 <= arr1, arr2 <= 1000], we use an array to count every element.
        int[] cnt = new int[1001];
        for (int n : arr1) cnt[n]++;
        // go through every element in the second array, and update values of the first array base on the order in the second array.
        int i = 0;
        for (int n : arr2) {
            while (cnt[n]-- > 0) arr1[i++] = n;
        }
        for (int n = 0; n < cnt.length; n++) {
            while (cnt[n]-- > 0) arr1[i++] = n;
        }
        return arr1;
    }

    /** if this constraint [0 <= arr1, arr2 <= 1000] doesn't exist, use {@link TreeMap} to replace above {@code int[] cnt = new int[1001]} */
    public int[] relativeSortArrayWithTreeMap(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int n : arr1) map.put(n, map.getOrDefault(n, 0) + 1);
        int i = 0;
        for (int n : arr2) {
            for (int j = 0; j < map.get(n); j++) arr1[i++] = n;
            map.remove(n);
        }
        for (int n : map.keySet()) {
            for (int j = 0; j < map.get(n); j++) arr1[i++] = n;
        }
        return arr1;
    }

}
