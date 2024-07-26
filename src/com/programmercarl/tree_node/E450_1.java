package com.programmercarl.tree_node;

/**
 * ClassName: E450_1
 * Package: com.programmercarl.tree_node
 * Description:
 *
 * @Author Zhirui Zhao
 * @Create 2024/7/9 9:24
 * @Version 1.0
 */
public class E450_1 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key){
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left != null && root.right != null) {
                if (root.right.left == null) {
                    // 右孩子就是最小后继，此时父节点是要被删除的节点，需要单独讨论
                    root.right.left = root.left;
                    return root.right;
                }
                // 找左边最大的节点
                TreeNode parent = root.right;
                TreeNode node = root.right.left;
                while (node.left != null) {
                    parent = node;
                    node = node.left;
                }

                // node指向左边最大节点
                // parent继承原本node的孩子
                parent.left = node.right;
                // node继承原root的孩子，成为新的root
                node.right = root.right;
                node.left = root.left;
                return node;
            }
            // 一个节点为空，返回那个非空的节点；都空返回空
            if (root.right == null) {
                return root.left;
            }
            return root.right;
        }
        return root;
    }
}
