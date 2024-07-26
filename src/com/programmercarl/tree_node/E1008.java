package com.programmercarl.tree_node;

/**
 * ClassName: E1008
 * Package: com.programmercarl.tree_node
 * Description:
 *
 * @Author Zhirui Zhao
 * @Create 2024/4/11 19:12
 * @Version 1.0
 */
public class E1008 {
    // 递归，O(nlogn)
    public TreeNode bstFromPreorder1(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 1; i < preorder.length; i++) {
            var val = preorder[i];
            insert1(root, val);
        }
        return root;
    }

    private TreeNode insert1(TreeNode node, int val) {
        if (node == null) {
            return new TreeNode(val);
        }
        if (val < node.val) {
            node.left = insert1(node.left, val);
        } else {
            node.right = insert1(node.right, val);
        }
        return node;
    }

    // 上限法递归，时间复杂度更小，O(n)
    public TreeNode bstFromPreorder2(int[] preorder) {
        return insert2(preorder, Integer.MAX_VALUE);
    }

    int i = 0;
    private TreeNode insert2(int[] preorder, int max) {
        if (i >= preorder.length) {
            return null;
        }
        int val = preorder[i];
        if (val > max) {
            return null;
        }
        TreeNode node = new TreeNode(val);
        i++;
        node.left = insert2(preorder, val);
        node.right = insert2(preorder, max);
        return node;
    }

    // 分治法递归
    // 8,5,1,7,10,12
    // 根 8，左 5 1 7，右 10 12
    // 根 5，左 1，右 7
    // 根10，左 null，右 12
    public TreeNode bstFromPreorder3(int[] preorder) {
        return partition(preorder, 0, preorder.length - 1);
    }

    // 处理[start, end]的部分
    private TreeNode partition(int[] preorder, int start, int end) {
        if (start > end) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[start]);
        int index = start + 1;
        while (index <= end && preorder[index] <= root.val) {
            index++;
        }
        root.left = partition(preorder, start + 1, index - 1);
        root.right = partition(preorder, index, end);
        return root;
    }
}





















































