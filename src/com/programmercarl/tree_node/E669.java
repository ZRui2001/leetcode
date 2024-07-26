package com.programmercarl.tree_node;

import org.junit.Test;

/**
 * ClassName: E669
 * Package: com.programmercarl.tree_node
 * Description:
 *
 * @Author Zhirui Zhao
 * @Create 2024/7/9 10:33
 * @Version 1.0
 */
public class E669 {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }

        if (root.val < low) {
            TreeNode cur = root;
            while (cur.right != null) {
                cur = cur.right;
                if (cur.val >= low) {
                    return trimBST(cur, low, high);
                }
            }
            return null;
        } else if (root.val > high) {
            TreeNode cur = root;
            while (cur.left != null) {
                cur = cur.left;
                if (cur.val <= high) {
                    return trimBST(cur, low, high);
                }
            }
            return null;
        }

        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }

    @Test
    public void test1(){
        TreeNode root = TreeNodeUtil.arrayToTree(new Integer[]{5, 0, 4, null, 2, null, null, 1});
        TreeNodeUtil.printTree(trimBST(root, 1, 3));
    }

}
