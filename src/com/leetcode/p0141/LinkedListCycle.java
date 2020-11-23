package com.leetcode.p0141;

// 141. 环形链表

import com.leetcode.common.ListNode;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {

    // 用一个 hashset 缓存已经出现过的节点，再循环遍历链表
//    public static boolean hasCycle(ListNode head) {
//        Set<ListNode> set = new HashSet<>();
//        ListNode node = head;
//        while (node != null) {
//            if (set.contains(node)) {
//                return true;
//            } else {
//                set.add(node);
//            }
//            node = node.next;
//        }
//        return false;
//    }

    // 快慢指针
    public static boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode slow = head, fast = head;
        while (slow.next != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next;

        System.out.println(hasCycle(head));
    }
}
