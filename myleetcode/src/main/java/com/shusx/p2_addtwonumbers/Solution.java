package com.shusx.p2_addtwonumbers;

/**
 * @Description
 * @Author shushengxiang
 * @Date 2019/9/10 15:37
 **/
public class Solution {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode value = root;
        int prev = 0;
        while(l1 != null || l2 != null || prev == 1){
            int val;
            if (l1 != null && l2 != null){
                val = l1.val + l2.val + prev;
            }else if (l1 != null){
                val = l1.val + prev;
            }else if (l2 != null){
                val = l2.val + prev;
            }else {
                val = prev;
            }
            if (val >= 10){
                value.next = new ListNode( val - 10);
                prev = 1;
            }else {
                value.next = new ListNode(val);
                prev = 0;
            }
            value = value.next;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        return root.next;
    }

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        System.out.println(addTwoNumbers(l1,l2));
    }
}
