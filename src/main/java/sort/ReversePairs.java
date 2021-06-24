package sort;

/**
 * @Author : Wu.D.J
 * @Create : 2021.01.04
 * @Problem : https://leetcode-cn.com/problems/reverse-pairs/
 * @Solution : https://leetcode.com/problems/reverse-pairs/discuss/97268/General-principles-behind-problems-similar-to-%22Reverse-Pairs%22
 * @Solution : https://leetcode-cn.com/problems/reverse-pairs/solution/shou-hua-tu-jie-yi-bu-yi-bu-jie-xi-gui-bing-pai-xu/  --归并排序
 * <p>
 * TODO  逆序对 : i < j, num[i] > num[j]
 */
public class ReversePairs {

    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] arr, int left, int right) {
        if (left >= right) return 0;
        int mid = (left + right) >> 1;
        int count = mergeSort(arr, left, mid) + mergeSort(arr, mid + 1, right);
        int[] merge = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0, p = mid + 1;
        while (i <= mid) {
            while (p <= right && arr[i] > 2L * arr[p]) p++;
            count += p - (mid + 1);
            while (j <= right && arr[i] >= arr[j]) merge[k++] = arr[j++];
            merge[k++] = arr[i++];
        }
        while (j <= right) merge[k++] = arr[j++];
        System.arraycopy(merge, 0, arr, left, merge.length);
        return count;
    }

}
