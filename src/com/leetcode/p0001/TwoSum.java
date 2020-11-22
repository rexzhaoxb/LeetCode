package com.leetcode.p0001;

// 1.两数之和

import java.util.HashMap;

public class TwoSum {
    // 暴力遍历  O(n^2)
//    public static int[] twoSum(int[] nums, int target) {
//        for (int i = 0; i < nums.length - 1; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[i] + nums[j] == target) return new int[]{i, j};
//            }
//        }
//        return null;
//    }

    // 用 hash 缓存出现过的值，这样每次一个新值过来，只要到hash中找自己需要的值，O(n)
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> cache = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            Integer index = cache.get(target - nums[i]);
            if (index != null) {
                return new int[] {index, i};
            } else {
                cache.put(nums[i], i);
            }
        }
        throw new IllegalArgumentException("No solutions");
    }

    public static void main(String[] args) {
        int[] x = twoSum(new int[]{21, 7, 8, 9, 34, 5, 0, 64}, 9);

        for (int i = 0; i < x.length; i++) {
            System.out.printf(String.valueOf(x[i]) + ", ");
        }
    }
}
