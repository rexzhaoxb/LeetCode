package com.leetcode.p0026;

import java.util.Arrays;

// 26. 删除排序数组中的重复项
public class RemoveDuplicatesFromSortedArray {
    // 暴力循环 O(n^2)
//    public static int removeDuplicates(int[] nums) {
//        if (nums.length < 2) return nums.length;
//        int length = nums.length;
//        for (int i = 0; i < length - 1;) {
//            if (nums[i] == nums[i + 1]) {
//                for (int j = i; j < length - 1; j++) {
//                    nums[j] = nums[j + 1];
//                }
//                length--;
//            } else {
//                i++;
//            }
//        }
//
//        return length;
//    }

    // 用一个指针记录处理好的尾部，用另外一个指针快速选择不重复的值，避免不必要的为临时中间状态拷贝 O(n)
    public static int removeDuplicates(int[] nums) {
        if (nums.length < 2) return nums.length;
        int length = nums.length, distinct = 0, fly = 1;
        for (int i = 1; i < length; i++) {
            if (nums[distinct] != nums[i]) {
                nums[++distinct] = nums[i];
            }
        }
        return distinct + 1;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }
}
