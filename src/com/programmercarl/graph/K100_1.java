package com.programmercarl.graph;

import java.util.Scanner;

/**
 * ClassName: K100_1
 * Package: com.programmercarl.graph
 * Description:
 *
 * @Author Zhirui Zhao
 * @Create 2024/6/20 13:00
 * @Version 1.0
 */
public class K100_1 {
    public int findLargestArea(char[][] grid) {
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    int area = dfs(i, j, grid);
                    maxArea = Integer.max(area, maxArea);
                }
            }
        }
        return maxArea;
    }

    private int dfs(int x, int y, char[][] grid) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == '0') {
            return 0;
        }

        grid[x][y] = '0';

        return dfs(x - 1, y, grid) + dfs(x + 1, y, grid) + dfs(x, y - 1, grid) + dfs(x, y + 1, grid) + 1;
    }




    public static void main(String[] args) {
        K100_1 entity = new K100_1();
        Scanner sc = new Scanner(System.in);

        int rows = sc.nextInt();
        int cols = sc.nextInt();

        char[][] grid = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = sc.next().charAt(0);
            }
        }

        System.out.println(entity.findLargestArea(grid));

        sc.close();
    }

}
