package com.programmercarl.tree_node;

/**
 * ClassName: InsertIntoBST
 * Package: com.programmercarl.tree_node
 * Description:
 * 701
 * @Author Zhirui Zhao
 * @Create 2024/4/7 23:11
 * @Version 1.0
 */
public class E701 {
    /*递归*/
    public TreeNode insertIntoBST1(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (val < root.val) {
            root.left = insertIntoBST1(root.left, val);
        } else if (val > root.val) {
            root.right = insertIntoBST1(root.right, val);
        }
        return root;
    }

    /*迭代*/
    public TreeNode insertIntoBST2(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        // 定位
        TreeNode p = root;
        TreeNode parent = null;
        while (p != null) {
            parent = p;
            if (val < p.val) {
                p = p.left;
            } else if (val > p.val) {
                p = p.right;
            }
        }

        // 插入
        if (val < parent.val) {
            parent.left = new TreeNode(val);
        } else {
            parent.right = new TreeNode(val);
        }
        return root;
    }
}
