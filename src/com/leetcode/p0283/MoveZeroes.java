package com.leetcode.p0283;

// 283.移动零

public class MoveZeroes {
    // 暴力法
    public static void moveZoreToEnd1(int[] nums) {
        int topLoop = nums.length;
        int i = 0;
        while (i < topLoop) {
            if (nums[i] == 0) {
                for (int j = i; j < nums.length - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                nums[nums.length - 1] = 0;
                topLoop--;
            } else {
                i++;
            }
        }
    }

    // 把非0元素都放到他们应该被调整至的位置，最后补零
    public static void moveZerosToEnd2(int[] nums) {
        int indexNotZero = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[++indexNotZero] = nums[i];
            }
        }
        for (int i = indexNotZero + 1; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 0,1,0,3,12};
        moveZerosToEnd2(nums);
        for (int num : nums) {
            System.out.printf(String.valueOf(num));
        }
    }
}
