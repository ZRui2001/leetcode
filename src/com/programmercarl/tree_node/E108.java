package com.programmercarl.tree_node;

/**
 * ClassName: E108
 * Package: com.programmercarl.tree_node
 * Description:
 *
 * @Author Zhirui Zhao
 * @Create 2024/7/10 9:08
 * @Version 1.0
 */
public class E108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildBST(0, nums.length, nums);
    }

    private TreeNode buildBST(int from, int to, int[] nums) {
        if (from >= to) {
            return null;
        }

        int mid = (from + to) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildBST(from, mid, nums);
        root.right = buildBST(mid + 1, to, nums);
        return root;
    }
}
