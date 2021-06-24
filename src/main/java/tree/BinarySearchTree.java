package tree;

/**
 * @Author : Avizii
 * @Create : 2021.03.10
 */
public class BinarySearchTree {

    private TreeNode root;

    public TreeNode get(int value) {
        TreeNode node = root;
        while (node != null) {
            if (value < node.val) node = node.left;
            else if (value > node.val) node = node.right;
            else return node;
        }
        return null;
    }

    public void add(int value) {
        if (root == null) {
            root = new TreeNode(value);
        } else {
            TreeNode node = root;
            while (node != null) {
                if (value > node.val) {
                    if (node.right == null) {
                        node.right = new TreeNode(value);
                    } else {
                        node = node.right;
                    }
                } else {
                    if (node.left == null) {
                        node.left = new TreeNode(value);
                    } else {
                        node = node.left;
                    }
                }
            }
        }
    }

    public void delete(int value) {
        TreeNode node = root;
        TreeNode parent = null;
        while (node != null && node.val != value) {
            parent = node;
            node = node.val > value ? node.right : node.left;
        }
        if (node == null) return;

        if (node.left != null && node.right != null) {
            TreeNode tempNode = node.right;
            TreeNode tempParent = node;
            while (tempNode.left != null) {
                tempParent = tempNode;
                tempNode = tempNode.left;
            }
            node.val = tempNode.val;
            node = tempNode;
            parent = tempParent;
        }

        TreeNode child;
        if (node.left != null) {
            child = node.left; // TODO 这个情况不可能发生，这块代码可优化成一行：TreeNode child = node.right;
        } else if (node.right != null) {
            child = node.right;
        } else {
            child = null;
        }

        if (parent == null) root = child;
        else if (parent.left == node) parent.left = child;
        else parent.right = child;
    }
}
