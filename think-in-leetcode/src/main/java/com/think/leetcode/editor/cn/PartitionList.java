package com.think.leetcode.editor.cn;

//给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。 
//
// 你应当 保留 两个分区中每个节点的初始相对位置。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,4,3,2,5,2], x = 3
//输出：[1,2,2,4,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [2,1], x = 2
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 200] 内 
// -100 <= Node.val <= 100 
// -200 <= x <= 200 
// 
//
// Related Topics链表 | 双指针 
//
// 👍 798, 👎 0 
//
//
//
//


public class PartitionList {
    public static void main(String[] args) {
        Solution solution = new PartitionList().new Solution();
        System.out.println(solution.partition(new ListNode(1), 0));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        // 分成两个小链，小于x的和大于等于x的;最后再合并成 结果链
        public ListNode partition(ListNode head, int x) {
            ListNode smallHeader = new ListNode(-1);
            ListNode bigHeader = new ListNode(-1);

            ListNode small = smallHeader;
            ListNode big = bigHeader;

            // 当前节点
            ListNode node = head;

            while (node != null) {
                if (node.val >= x) {
                    big.next = node;
                    big = big.next;
                } else {
                    small.next = node;
                    small = small.next;
                }
                ListNode tempNode = node.next;
                node.next = null;
                node = tempNode;
            }

            // 合并链，当前短链的下一个连接上大链头的下一个（也就是真实的节点）
            small.next = bigHeader.next;

            return smallHeader.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}