package tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author : Wu.D.J
 * @Create : 2020.12.21
 * @Problem : https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
 * @Sequence : 297
 */
public class SerializeAndDeserializeBinaryTree {

    public String serialize(TreeNode root) {
        return serialDFS(root, "");
    }

    private String serialDFS(TreeNode root, String s) {
        if (root == null) {
            s += "None,";
        } else {
            s += root.val + ",";
            s = serialDFS(root.left, s);
            s = serialDFS(root.right, s);
        }
        return s;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodeArr = data.split(",");
        List<String> list = new LinkedList<>(Arrays.asList(nodeArr));
        return deserialDFS(list);
    }

    private TreeNode deserialDFS(List<String> list) {
        String element = list.remove(0);
        if (element.equals("None")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(element));
        root.left = deserialDFS(list);
        root.right = deserialDFS(list);
        return root;
    }
}
