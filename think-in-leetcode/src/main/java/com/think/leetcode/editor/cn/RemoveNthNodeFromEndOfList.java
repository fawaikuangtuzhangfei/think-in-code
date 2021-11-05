package com.think.leetcode.editor.cn;

// leetcode 19 m 删除链表的倒数第 N 个结点
// 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
//
// 进阶：你能尝试使用一趟扫描实现吗？ 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
// 5-2=3倒2正三
// 
//
// 示例 2： 
//
// 
//输入：head = [1], n = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2], n = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中结点的数目为 sz 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
// Related Topics 链表 双指针 👍 1634 👎 0

import java.util.Stack;

public class RemoveNthNodeFromEndOfList{
    public static void main(String[] args) {
        Solution solution = new RemoveNthNodeFromEndOfList().new Solution();
        ListNode root = new ListNode(1, new ListNode(2, null));
        solution.removeNthFromEnd(root, 2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * 链表题-最好先在头节点前面设置一个哑节点，哑节点指向头节点
 * 返回时直接返回哑节点的下一个节点；在操作头节点的时候也便于操作
 * Solution1：
 * 遍历两次，第一次拿到总长度，第二次进行删除节点
 * 边界：删除头节点
 *
 * Solution2：
 * 利用栈的先进后出，第n个出栈的就是要删除的节点
 * 将n+1和n-1连接起来
 *
 * Solution:
 * 双指针，快指针优先于慢指针n个节点
 * 当快指针到达链表尾部时，慢指针到达倒数第n个节点
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode root = new ListNode(0, head);
        ListNode slow = root;
        ListNode quick = head;
        for(int i=0; i<n; i++){
            quick = quick.next;
        }
        while (quick != null) {
            slow = slow.next;
            quick = quick.next;
        }
        slow.next = slow.next.next;
        return root.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

    class Solution1 {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode root = head;
            int length = 0;
            while(root != null){
                length++;
                root = root.next;
            }
            if(n == length){
                head = head.next;
                return head;
            }
            n = length - n;
            root = head;
            int i = 1;
            while(root != null){
                if(n == i){
                    ListNode next = root.next;
                    root.next = next.next;
                }
                i++;
                root = root.next;
            }
            return head;
        }
    }

    class Solution2 {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode root = new ListNode(0, head);
            Stack<ListNode> stack = new Stack<>();
            ListNode cur = root;
            while (cur != null){
                stack.push(cur);
                cur = cur.next;
            }
            for(int i=0; i<n; i++){
                stack.pop();
            }
            ListNode pre = stack.peek();
            pre.next = pre.next.next;
            return root.next;
        }
    }

}