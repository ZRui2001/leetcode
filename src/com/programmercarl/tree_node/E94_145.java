package com.programmercarl.tree_node;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * ClassName: Traversal
 * Package: com.programmercarl.tree_node
 * Description:
 * 94, 145
 * @Author Zhirui Zhao
 * @Create 2024/3/26 16:47
 * @Version 1.0
 */
public class E94_145 {
    public List<Integer> preorderTraversal(TreeNode root) {
        // 指向当前访问的节点
        TreeNode cur = root;
        // 存放上一个弹出的节点
        TreeNode pop = null;
        // 存放之前访问过的节点
        LinkedList<TreeNode> stack = new LinkedList<>();
        List<Integer> res = new ArrayList<>();


        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                // 前序遍历
//                res.add(cur.val);
                stack.push(cur);
                // 访问左子树
                cur = cur.left;
            } else {
                TreeNode peek = stack.peek();
                // 没有右子树
                if (peek.right == null) {
                    pop = stack.pop();
                    // 中序遍历
//                    res.add(pop.val);
                    // 后序遍历
                    res.add(pop.val);
                }
                // 右子树搜索完成
                else if (pop == peek.right) {
                    pop = stack.pop();
                    // 后序遍历
                    res.add(pop.val);
                }
                // 有右子树
                else {
                    cur = peek.right;
                    // 中序遍历
//                    res.add(peek.val);  中序遍历
                }
            }
        }
        return res;
    }
}
