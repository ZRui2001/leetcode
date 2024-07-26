package com.programmercarl.tree_node;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ClassName: E501
 * Package: com.programmercarl.tree_node
 * Description:
 *
 * @Author Zhirui Zhao
 * @Create 2024/7/8 9:47
 * @Version 1.0
 */
public class E501 {

    TreeNode pre;
    int count;
    int maxCount;
    List<Integer> result;

    public int[] findMode(TreeNode root) {
        pre = null;
        count = 0;
        maxCount = 0;
        result = new ArrayList<>();
        searchBST(root);
        int[] resultArray = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }
        return resultArray;
    }

    private void searchBST(TreeNode node) {
        if (node == null) {
            return;
        }

        searchBST(node.left);

        // 计数
        if (pre != null && pre.val < node.val) {
            count = 1;
        } else {
            count++;
        }
        // 更新maxCount和result
        if (count > maxCount) {
            maxCount = count;
            result.clear();
            result.add(node.val);
        } else if (count == maxCount) {
            result.add(node.val);
        }
        pre = node;


        searchBST(node.right);
    }

    @Test
    public void test1(){
        TreeNode root = TreeNodeUtil.arrayToTree(new Integer[]{1,null,2,2});
        System.out.println(Arrays.toString(findMode(root)));
    }
}
