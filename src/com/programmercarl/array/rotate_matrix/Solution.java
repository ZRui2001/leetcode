package com.programmercarl.array.rotate_matrix;

import java.util.Arrays;

/**
 * ClassName: com.programmercarl.array.q59.Solution59
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author Zhirui Zhao
 * @Create 2024/3/3 14:09
 * @Version 1.0
 */
public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        update(res, res[0].length, 0, 1);
        return res;
    }

    void update(int[][] nums, int size, int startIdx, int startNum) {
        if (size == 0) {
            return;
        } else if (size == 1) {
            nums[startIdx][startIdx] = startNum;
            return;
        }
        // 更新外圈
        nums[startIdx][startIdx] = startNum;
        int i, j;
        i = j = startIdx;
        // right(size - 1);
        for (int k = 0; k < size - 1; k++) {
            nums[i][++j] = ++startNum;
        }
        // down(size - 1);
        for (int k = 0; k < size - 1; k++) {
            nums[++i][j] = ++startNum;
        }
        // left(size - 1);
        for (int k = 0; k < size - 1; k++) {
            nums[i][--j] = ++startNum;
        }
        // up(size - 2);
        for (int k = 0; k < size - 2; k++) {
            nums[--i][j] = ++startNum;
        }
        // 递归
        update(nums, size - 2, startIdx + 1, startNum + 1);
    }

    public static void main(String[] args) {
        Solution ans = new Solution();
        System.out.println(Arrays.deepToString(ans.generateMatrix(5)));
    }
}
