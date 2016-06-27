package com.leetcode.qindipku.java;

/**
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 * 
 * For example:
 * Given 1->2->3->4->5->NULL and k = 2,
 * return 4->5->1->2->3->NULL.
 * 
 * @author qindi
 *
 */
public class _61RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (0 == k || null == head) {
            return head;
        }
        
        int nodeCount = 1;
        ListNode end = head;
        while (end.next != null) {
            end = end.next;
            nodeCount++;
        }
        end.next = head;
        k = k % nodeCount;
        
        ListNode left = head, right = head;
        int count = 0;
        while (right.next != head) {
            if (count == k) {
                right = right.next;
                left = left.next;
            } else {
                right = right.next;
                count++;
            }
        }
        
        right.next = head;
        head = left.next;
        left.next = null;
        
        return head;
    }

    public void print(ListNode head) {
        ListNode p = head;
        while (p != null) {
            System.out.print(p.val + "->");
            p = p.next;
        }
        System.out.println("null");
    }
    
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        _61RotateList solution = new _61RotateList();
        solution.print(head);
        solution.print(solution.rotateRight(head, 2));
        
        head = new ListNode(1, new ListNode(2, null));
        solution.print(solution.rotateRight(head, 2));
    }
}
