package com.programmercarl.greedy;

import java.util.Arrays;

/**
 * ClassName: E455
 * Package: com.programmercarl.greedy
 * Description:
 *
 * @Author Zhirui Zhao
 * @Create 2024/5/30 22:23
 * @Version 1.0
 */
public class E455 {
//    public int findContentChildren(int[] g, int[] s) {
//        // every biscuit finds the one with the greatest appetite among all the kids
//        // whose appetite is more than the biscuit's value
//        int count = 0;
//        for (int biscuitSize : s) {
//            // find the one with the greatest appetite among all the kids whose appetite <= the biscuit's value
//            int maxKid = -1;
//            int lastMax = 0;
//            for (int i = 0; i < g.length; i++) {
//                if (g[i] <= biscuitSize && g[i] > lastMax) {
//                    // biscuit's value >= kid's appetite
//                    maxKid = i;
//                    lastMax = g[maxKid];
//                }
//            }
//            if (maxKid >= 0 && g[maxKid] != 0) {
//                g[maxKid] = 0;
//                count++;
//            }
//        }
//        return count;
//    }

    // every biscuit finds the one with the greatest appetite among all the kids
    // whose appetite is more than the biscuit's value
    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int count = 0;
        int kidIdx = g.length - 1;
        for (int cookieIdx = s.length - 1; cookieIdx >= 0; cookieIdx--) {
            while (kidIdx >= 0 && g[kidIdx] > s[cookieIdx]) {
                kidIdx--;
            }
            if (kidIdx < 0) {
                break;
            }
            count++;
            kidIdx--;
        }

        return count;
    }

    public static void main(String[] args) {
        int[] g = new int[]{10,9,8,7};
        int[] s = new int[]{5,6,7,8};
        System.out.println(findContentChildren(g, s));
    }
}
