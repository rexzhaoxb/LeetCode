package com.leetcode.p0070;

// 70.爬楼梯

import java.util.HashMap;

public class ClimbingStairs {
    // 傻递归
//    public static int climbStairs(int n) {
//        if (n <= 2) return n;
//        return climbStairs(n - 1) + climbStairs(n - 2);
//    }

    // 带重复值缓存的递归, O(log n)
//    static HashMap<Integer, Integer> cache = new HashMap<>(10);
//    public static int climbStairs(int n) {
//        if (n <= 2) return n;
//        Integer getValue = cache.get(Integer.valueOf(n));
//        if (getValue != null) return getValue.intValue();
//        int x = climbStairs(n - 1) + climbStairs(n - 2);
//        cache.put(n , x);
//        return x;
//    }

    // 用一个 O(n) 循环
    public static int climbStairs(int n) {
        if (n <= 2) return n;
        int s1 = 1;
        int s2 = 2;
        int s3 = 0;

        for (int i = 3; i <= n; i++) {
            s3 = s1 + s2;
            s1 = s2;
            s2 = s3;
        }

        return s3;
    }

    public static void main(String[] args) {
        System.out.printf(String.valueOf(climbStairs(45)));
    }
}
