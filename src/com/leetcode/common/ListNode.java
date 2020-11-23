package com.leetcode.common;

public class ListNode {
    int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int x) {
        val = x;
    }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public String toString() {
        ListNode current = this;
        StringBuilder sb = new StringBuilder();

        sb.append(current.val);

        while (current.next != null) {
            current = current.next;
            sb.append(" -> ");
            sb.append(current.val);
        }

        sb.append(" -> NULL");

        return sb.toString();
    }

    public int getVal() {
        return val;
    }
}
