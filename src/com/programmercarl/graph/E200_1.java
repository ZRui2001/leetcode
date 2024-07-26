package com.programmercarl.graph;

/**
 * ClassName: E200
 * Package: com.programmercarl.graph
 * Description:
 *
 * @Author Zhirui Zhao
 * @Create 2024/6/15 14:05
 * @Version 1.0
 */
public class E200_1 {

    public int numIslands(char[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    result++;
                    dfs(grid, i, j);
                }
            }
        }
        return result;
    }

    private void dfs(char[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == '0') {
            return;
        }
        grid[x][y] = '0';
        
        dfs(grid, x + 1, y);
        dfs(grid, x, y - 1);
        dfs(grid, x - 1, y);
        dfs(grid, x, y + 1);
    }
}
