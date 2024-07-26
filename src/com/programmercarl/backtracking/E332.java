package com.programmercarl.backtracking;

import com.programmercarl.utils.DebugUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: E332
 * Package: com.programmercarl.backtracking
 * Description:
 *
 * @Author Zhirui Zhao
 * @Create 2024/7/19 9:08
 * @Version 1.0
 */
public class E332 {

    List<String> result;
    List<String> path;
    boolean[] used;

    public List<String> findItinerary(List<List<String>> tickets) {
        result = new ArrayList<>();
        path = new ArrayList<>();
        used = new boolean[tickets.size()];
        backtracking(tickets);
        return result;
    }

    private void backtracking(List<List<String>> tickets) {
        if (path.size() >= tickets.size() + 1) {
            // 判断path和现在的result谁更小
            if (result.isEmpty()) {
                result = new ArrayList<>(path);
                return;
            }
            for (int i = 0; i < path.size(); i++) {
                if (path.get(i).compareTo(result.get(i)) < 0) {
                    result = new ArrayList<>(path);
                    break;
                }
                if (path.get(i).compareTo(result.get(i)) > 0) {
                    break;
                }
            }
            return;
        }

        if (path.isEmpty()) {
            // 保证从JFK出发
            for (int i = 0; i < tickets.size(); i++) {
                if ("JFK".equals(tickets.get(i).get(0))) {
                    path.add(tickets.get(i).get(0));
                    path.add(tickets.get(i).get(1));
                    used[i] = true;

                    backtracking(tickets);

                    used[i] = false;
                    path.remove(path.size() - 1);
                    path.remove(path.size() - 1);
                }
            }
        } else {
            // 对票排列
            for (int i = 0; i < tickets.size(); i++) {
                // 树枝过滤
                if (used[i]) {
                    continue;
                }

                // 判断票能否对上
                if (tickets.get(i).get(0).equals(path.get(path.size() - 1))) {
                    path.add(tickets.get(i).get(1));
                    used[i] = true;

                    backtracking(tickets);

                    used[i] = false;
                    path.remove(path.size() - 1);
                }
            }
        }
    }

    @Test
    public void test1(){
        List<List<String>> list = DebugUtil.parseStringTo2DList("[[\"JFK\",\"SFO\"],[\"JFK\",\"ATL\"]" +
                ",[\"SFO\",\"ATL\"],[\"ATL\",\"JFK\"],[\"ATL\",\"SFO\"]]");
        findItinerary(list).forEach(System.out::println);
    }

    @Test
    public void test2(){
        System.out.println("SFO".compareTo("JFK"));
    }
}
