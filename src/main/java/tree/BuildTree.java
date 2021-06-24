package tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author : Avizii
 * @Create : 2021.01.15
 * @CN-URL : https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 * @EN-URL : https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/discuss/?currentPage=1&orderBy=most_votes&query=&tag=java
 * @Solve1 : https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--22/
 * @Solve2 : https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/discuss/34555/The-iterative-solution-is-easier-than-you-think!
 * @Solve3 : https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/solution/di-gui-gou-jian-by-yanyufang/
 */
public class BuildTree {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 设置两个指针指向开头和结束来代表切割逻辑
        return dfs(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    private TreeNode dfs(int[] preorder, int preStart, int preEnd,
                         int[] inorder, int inStart, int inEnd) {
        // terminal
        if (preStart == preEnd) return null;

        // process logic
        // 根据前序遍历的第一个值，在中序遍历中寻找根节点位置
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = 0;
        for (int i = inStart; i < inEnd; i++) {
            if (inorder[i] == rootVal) {
                rootIndex = i;
                break;
            }
        }
        // 根据中序遍历根节点位置，计算前序遍历中左子树个数
        int leftSize = rootIndex - inStart;

        // drill down
        // 递归构造左子树，注意双指针区间为左闭右开
        root.left = dfs(preorder, preStart + 1, preStart + leftSize + 1, inorder, inStart, rootIndex);

        // 递归构造右子树
        root.right = dfs(preorder, preStart + leftSize + 1, preEnd, inorder, rootIndex + 1, inEnd);

        // reverse state
        return root;
    }

    public TreeNode buildTreeMap(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return dfs(preorder, 0, preorder.length, inorder, 0, inorder.length, map);
    }

    private TreeNode dfs(int[] preorder, int preStart, int preEnd,
                         int[] inorder, int inStart, int inEnd,
                         Map<Integer, Integer> map) {
        if (preStart == preEnd) return null;
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        int rootIndexInorder = map.get(rootVal);
        int leftNum = rootIndexInorder - inStart;
        root.left = dfs(preorder, preStart + 1, preStart + leftNum + 1, inorder, inStart, rootIndexInorder, map);
        root.right = dfs(preorder, preStart + leftNum + 1, preEnd, inorder, rootIndexInorder + 1, inEnd, map);
        return root;
    }
}
