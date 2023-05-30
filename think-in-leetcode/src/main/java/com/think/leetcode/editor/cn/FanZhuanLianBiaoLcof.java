package com.think.leetcode.editor.cn; 

//定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。 
//
// 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 5000 
//
// 
//
// 注意：本题与主站 206 题相同：https://leetcode-cn.com/problems/reverse-linked-list/ 
// 👍 585 👎 0


public class FanZhuanLianBiaoLcof{
    public static void main(String[] args) {
        Solution solution = new FanZhuanLianBiaoLcof().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public ListNode reverseList(ListNode head) {
        // 当前节点
        ListNode current = head;
        // 前一个节点
        ListNode pre = null;
        while (current != null){
            // 后一个
            ListNode next = current.next;
            // 后指前
            current.next = pre;
            // 前=当前
            pre = current;
            // 当前后移
            current = next;

        }
        return pre;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
static class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
}
