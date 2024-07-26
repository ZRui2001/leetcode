package com.programmercarl.utils;

import java.util.List;

/**
 * ClassName: DebugUtilTest
 * Package: com.programmercarl.utils
 * Description:
 *
 * @Author Zhirui Zhao
 * @Create 2024/7/19 13:09
 * @Version 1.0
 */
public class DebugUtilTest {
    public static void main(String[] args) {
        List<List<String>> list = DebugUtil.parseStringTo2DList("[[\"JFK\",\"SFO\"]" +
                ",[\"JFK\",\"ATL\"],[\"SFO\",\"ATL\"],[\"ATL\",\"JFK\"],[\"ATL\",\"SFO\"]]");
        list.forEach(System.out::println);
    }
}
