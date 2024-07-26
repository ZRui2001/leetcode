package com.programmercarl.sort;

import java.util.Arrays;

/**
 * ClassName: E1636
 * Package: com.programmercarl.sort
 * Description:
 *
 * @Author Zhirui Zhao
 * @Create 2024/5/26 15:10
 * @Version 1.0
 */
public class E1636 {
    public int[] frequencySort(int[] nums) {
        int[] count = new int[201];
        for(int i : nums) {
            count[i + 100]++;
        }

        return Arrays.stream(nums).boxed().sorted((a, b) -> {
            int af = count[a + 100];
            int bf = count[b + 100];
            if (af > bf) {
                return 1;
            } else if (af < bf) {
                return -1;
            } else {
                return b - a;
            }
        } ).mapToInt(Integer::intValue).toArray();
    }
}
