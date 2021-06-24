package tree;

import java.util.*;

/**
 * @Author : Wu.D.J
 * @Create : 2020.12.22
 * @Problem : https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 * @Problem : https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 * @Problem : https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 * @Problem : https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 * @Solution : https://leetcode-cn.com/problems/binary-tree-preorder-traversal/solution/leetcodesuan-fa-xiu-lian-dong-hua-yan-shi-xbian-2/
 * @Solution : https://leetcode-cn.com/problems/binary-tree-preorder-traversal/solution/tu-jie-er-cha-shu-de-si-chong-bian-li-by-z1m/
 * @Solution : https://leetcode-cn.com/problems/binary-tree-level-order-traversal/solution/bfs-de-shi-yong-chang-jing-zong-jie-ceng-xu-bian-l/
 *
 *
 * 中序遍历校验二叉搜索树 https://leetcode-cn.com/problems/validate-binary-search-tree/
 * 中序遍历寻找二叉搜索树第k个小的数  https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/
 * 层序遍历寻找二叉树每一行最大值 https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/
 */
public class BinaryTreeTraversal {

    private final List<Integer> list = new ArrayList<>();

    /**
     * @TimeComplexity : O(n)
     * @SpaceComplexity : average -> O(logn); worst -> O(n)
     */
    public List<Integer> preOrder(TreeNode root) {
        if (root == null) return list;
        list.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
        return list;
    }

    /**
     * @TimeComplexity : O(n)
     * @SpaceComplexity : average -> O(logn); worst -> O(n)
     */
    public List<Integer> preOrderIterable(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                list.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode node = stack.pop();
            cur = node.right;
        }
        return list;
    }

    //------------------------------------------------------------------------------
    public List<Integer> inOrder(TreeNode root) {
        if (root == null) return list;
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
        return list;
    }

    public List<Integer> inOrderIterable(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode node = stack.pop();
            list.add(node.val);
            cur = node.right;
        }
        return list;
    }

    //------------------------------------------------------------------------------

    public List<Integer> postOrder(TreeNode root) {
        if (root == null) return list;
        postOrder(root.left);
        postOrder(root.right);
        list.add(root.val);
        return list;
    }

    public List<Integer> postOrderIterable(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        TreeNode cursor = root;
        while (!stack.isEmpty() || cursor != null) {
            while (cursor != null) {
                list.add(cursor.val);
                stack.push(cursor);
                cursor = cursor.right;
            }
            TreeNode node = stack.pop();
            cursor = node.left;
        }
        Collections.reverse(list);
        return list;
    }

    //------------------------------------------------------------------------------
    // https://leetcode-cn.com/problems/binary-tree-level-order-traversal/solution/bfs-de-shi-yong-chang-jing-zong-jie-ceng-xu-bian-l/
    // https://leetcode-cn.com/problems/binary-tree-level-order-traversal/solution/die-dai-di-gui-duo-tu-yan-shi-102er-cha-shu-de-cen/
    //------------------------------------------------------------------------------

    public List<List<Integer>> levelOrderQueue(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root != null) queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            list.add(level);
        }
        return list;
    }



}
