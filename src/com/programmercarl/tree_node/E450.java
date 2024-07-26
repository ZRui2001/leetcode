package com.programmercarl.tree_node;

/**
 * ClassName: DeleteNode
 * Package: com.programmercarl.tree_node
 * Description:
 * 450
 * @Author Zhirui Zhao
 * @Create 2024/4/2 21:58
 * @Version 1.0
 */
public class E450 {
    /**
     * 递归
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        TreeNode node = root;

        if (key < node.val) {
            node.left = deleteNode(node.left, key);
            return node;
        } else if (key > node.val) {
            node.right = deleteNode(node.right, key);
            return node;
        } else {
            // 找到目标节点
            if (node.right == null) {
                // 有左子树，没有右子树
                return node.left;
            } else if (node.left == null) {
                // 有右子树，没有左子树
                return node.right;
            }  else {
                // 有左右子树，找最小后任
                node = node.right;
                TreeNode pos = node;

                // 右孩子的左子树的最左端节点为最小后任
                while (node.left != null) {
                    node = node.left;
                }
                node.right = deleteNode(pos, node.val);
                node.left = root.left;
                return node;
            }
        }
    }
}
