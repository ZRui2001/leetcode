package com.programmercarl.tree_node;

/**
 * ClassName: E654
 * Package: com.programmercarl.tree_node
 * Description:
 *
 * @Author Zhirui Zhao
 * @Create 2024/7/5 9:21
 * @Version 1.0
 */
public class E654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return dfs(nums, 0, nums.length);
    }

    private TreeNode dfs(int[] nums, int from, int to) {

        if (from >= to) {
            return null;
        }

        if (from == to - 1) {
            return new TreeNode(nums[from]);
        }

        int maxIndex = from;
        for (int i = from + 1; i < to; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }

        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = dfs(nums, from, maxIndex);
        root.right = dfs(nums, maxIndex + 1, to);
        return root;
    }
}
