package com.programmercarl.tree_node;


import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: E106
 * Package: com.programmercarl.tree_node
 * Description:
 *
 * @Author Zhirui Zhao
 * @Create 2024/7/3 10:14
 * @Version 1.0
 */
public class E106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(inorder, 0, postorder, 0, inorder.length, map);
    }

    private TreeNode build(int[] inorder, int inFrom, int[] postorder, int postFrom, int length, Map<Integer, Integer> map) {
        if (length <= 0) {
            return null;
        }
        if (length == 1) {
            return new TreeNode(inorder[inFrom]);
        }

        TreeNode root = new TreeNode(postorder[postFrom + length - 1]);
        int delimiterIdx = map.get(root.val);  // 找分隔点是最耗时的步骤，用Map把查找时间从O(n)降至O(1)

        int leftInFrom = inFrom;
        int leftPostFrom = postFrom;
        int leftLength = delimiterIdx - inFrom;
        int rightInFrom = delimiterIdx + 1;
        int rightPostFrom = leftLength + postFrom;
        int rightLength = length - leftLength - 1;


        root.left = build(inorder, leftInFrom, postorder, leftPostFrom, leftLength, map);
        root.right = build(inorder, rightInFrom, postorder, rightPostFrom, rightLength, map);

        return root;
    }
}
