package com.programmercarl.utils;

import com.programmercarl.tree_node.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ClassName: DebugUtil
 * Package: com.programmercarl.utils
 * Description:
 *
 * @Author Zhirui Zhao
 * @Create 2024/7/19 13:07
 * @Version 1.0
 */
public class DebugUtil {
    public static TreeNode arrayToTree(Integer[] array) {
        if (array == null || array.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(array[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (i < array.length) {
            TreeNode current = queue.poll();

            if (array[i] != null) {
                current.left = new TreeNode(array[i]);
                queue.offer(current.left);
            }
            i++;

            if (i < array.length && array[i] != null) {
                current.right = new TreeNode(array[i]);
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }

    public static List<List<String>> parseStringTo2DList(String input) {
        List<List<String>> list2D = new ArrayList<>();
        // 正则表达式解析字符串
        Pattern pattern = Pattern.compile("\\[\"(.*?)\"\\]");
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            String[] elements = matcher.group(1).split("\",\"");
            List<String> innerList = new ArrayList<>();
            for (String element : elements) {
                innerList.add(element);
            }
            list2D.add(innerList);
        }
        return list2D;
    }

    public static char[][] convertJsonStringToCharArray(String jsonString) {
        // 去掉开头的[[和结尾的]]
        String trimmedString = jsonString.substring(2, jsonString.length() - 2);

        // 拆分成行
        String[] rows = trimmedString.split("\\],\\[");

        int numRows = rows.length;
        int numCols = rows[0].split("\",\"").length;

        char[][] charArray = new char[numRows][numCols];

        for (int i = 0; i < numRows; i++) {
            // 去掉每行开头和结尾的双引号
            String row = rows[i].replaceAll("^\"|\"$", "");

            // 拆分成单元格
            String[] cells = row.split("\",\"");

            for (int j = 0; j < numCols; j++) {
                charArray[i][j] = cells[j].charAt(0);
            }
        }

        return charArray;
    }
}
