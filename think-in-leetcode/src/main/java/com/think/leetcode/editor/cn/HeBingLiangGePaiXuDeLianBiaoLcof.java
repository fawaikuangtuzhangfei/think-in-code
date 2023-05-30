package com.think.leetcode.editor.cn; 

//输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。 
//
// 示例1： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4 
//
// 限制： 
//
// 0 <= 链表长度 <= 1000 
//
// 注意：本题与主站 21 题相同：https://leetcode-cn.com/problems/merge-two-sorted-lists/ 
// 👍 349 👎 0


public class HeBingLiangGePaiXuDeLianBiaoLcof{
    public static void main(String[] args) {
        Solution solution = new HeBingLiangGePaiXuDeLianBiaoLcof().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(-1);
        ListNode current = result;
        while(l1 != null && l2 != null){
            if(l1.val > l2.val){
                current.next = l2;
                l2 = l2.next;
            }else{
                current.next = l1;
                l1 = l1.next;
            }
            current = current.next;
        }
        // 任一到达末尾了都直接复制到链条上
        if(l1 != null){
            current.next = l1;
        }else{
            current.next = l2;
        }
        return result.next;
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
