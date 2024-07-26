package com.programmercarl.graph;

import org.junit.Test;

import java.util.*;

/**
 * ClassName: E797
 * Package: com.programmercarl.graph
 * Description:
 *
 * @Author Zhirui Zhao
 * @Create 2024/6/14 17:08
 * @Version 1.0
 */
public class E797 {

    LinkedList<Integer> path;
    List<List<Integer>> result;

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        path = new LinkedList<>();
        result = new ArrayList<>();
        dfs(0, graph);
        return result;
    }

    private void dfs(int n, int[][] graph) {
        path.offerLast(n);

        if (n == graph.length - 1) {
            result.add(new ArrayList<>(path));
            path.pollLast();
            return;
        }

        for (int neighbor : graph[n]) {
            dfs(neighbor, graph);
        }
        path.pollLast();
    }

    @Test
    public void test0(){
        int[][] graph = {{1,2},{3},{3},{}};
        System.out.println(allPathsSourceTarget(graph));
    }

}
