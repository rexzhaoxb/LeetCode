package com.leetcode.p0011;

// 11.装最多水问题

public class ContainerWithMostWater {
    // 暴力法
//    public static int maxArea(int[] height) {
//        int max = 0;
//        for (int i = 1; i < height.length; i++) {
//            for (int j = 0; j < i; j++) {
//                int current = (i - j) * Math.min(height[i], height[j]);
//                max = Math.max(current, max);
//            }
//        }
//        return max;
//    }

    // 基于最大的底，往中间收敛找寻相对更高的高，比较保持最大值
    public static int maxArea(int[] height) {
        int max = 0;
        int head = 0;
        int tail = height.length - 1;
        while (head < tail) {
            int current = (tail - head) * Math.min(height[head], height[tail]);
            max = Math.max(current, max);
            if (height[head] < height[tail]) {
                head ++;
            } else {
                tail--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] heights = {1,8,6,2,5,4,8,3,7};
        int maxArea = maxArea(heights);

        System.out.printf("The max area is: " + String.valueOf(maxArea));
    }
}
