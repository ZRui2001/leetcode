package com.programmercarl.backtracking;

import java.util.*;

/**
 * ClassName: E332_1
 * Package: com.programmercarl.backtracking
 * Description:
 *
 * @Author Zhirui Zhao
 * @Create 2024/7/19 14:33
 * @Version 1.0
 */
public class E332_1 {

    LinkedList<String> result;
    // 第一个String：出发地
    // 第二个String：目的地
    // Integer：有几张出发地->目的地的票
    Map<String, Map<String, Integer>> map;

    public List<String> findItinerary(List<List<String>> tickets) {
        result = new LinkedList<>();
        map = getMap(tickets);
        result.add("JFK");
        backtracking(tickets.size());
        return result;
    }

    private Map<String, Map<String, Integer>> getMap(List<List<String>> tickets) {
        Map<String, Map<String, Integer>> map = new HashMap<>();
        for (List<String> ticket : tickets) {
            String start = ticket.get(0);
            String destination = ticket.get(1);
            if (map.containsKey(start)) {
                Map<String, Integer> destMap = map.get(start);
                destMap.put(destination, destMap.getOrDefault(destination, 0) + 1);
            } else {
                Map<String, Integer> destMap = new TreeMap<>();  // 实现自然（按字典）排序
                destMap.put(destination, 1);
                map.put(start, destMap);
            }
        }
        return map;
    }

    private boolean backtracking(int ticketNum) {
        if (result.size() == ticketNum + 1) {
            return true;
        }

        String start = result.getLast();
        Map<String, Integer> destMap = map.get(start);
        // 排除没有目的地的地点
        if (destMap == null) {
            return false;
        }

        for (Map.Entry<String, Integer> destEntry : destMap.entrySet()) {
            String destination = destEntry.getKey();
            Integer count = destEntry.getValue();
            if (destEntry.getValue() > 0) {
                result.add(destination);
                destEntry.setValue(count - 1);
                if (backtracking(ticketNum)) {
                    // 搜索到的第一个路径，就是字典排序最前的结果，直接结束递归
                    return true;
                }
                destEntry.setValue(count);
                result.removeLast();
            }
        }
        return false;
    }
}
