package tree;

/**
 * @Author : Avizii
 * @Create : 2021.03.23
 */
public class TreeSimpleQuestionSet {

    /**
     * @Name : 翻转二叉树
     * @Url : https://leetcode-cn.com/problems/invert-binary-tree
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    /**
     * @Name : 二叉树的最大深度
     * @Url : https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
     */
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int max_left = maxDepth(root.left);
        int max_right = maxDepth(root.right);
        return Math.max(max_left, max_right) + 1;
    }

    /**
     * @Name : 二叉树的最小深度
     * @Url : https://leetcode-cn.com/problems/minimum-depth-of-binary-tree
     */
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int left_min = minDepth(root.left);
        int right_min = minDepth(root.right);
        return root.left == null || root.right == null ? left_min + right_min + 1 : Math.min(left_min, right_min) + 1;
    }
}
