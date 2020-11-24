package com.leetcode.p0189;

import java.util.Arrays;

// 189. 旋转数组
public class RotateArray {

    // 暴力法 O(n^2)
//    public static void rotate(int[] nums, int k) {
//        for (int i = 0; i < k; i++) {
//            int last = nums[nums.length - 1];
//            for (int j = nums.length - 1; j >= 1; j--) {
//                nums[j] = nums[j - 1];
//            }
//            nums[0] = last;
//        }
//    }

    // 用一个副本做为数据来源，利用模运算直接一个坑一个坑的复制。 O(n)
    public static void rotate(int[] nums, int k) {
        if (k % nums.length == 0) return;
        int[] bak = nums.clone();
        for (int i = 0; i < nums.length; i++) {
            nums[(i + k) % nums.length] = bak[i];
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }
}
