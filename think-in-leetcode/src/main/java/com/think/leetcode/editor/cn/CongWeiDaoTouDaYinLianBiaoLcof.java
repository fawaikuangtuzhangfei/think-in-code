////输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。 
////
//// 
////
//// 示例 1： 
////
//// 输入：head = [1,3,2]
////输出：[2,3,1] 
////
//// 
////
//// 限制： 
////
//// 0 <= 链表长度 <= 10000 
//// Related Topics 栈 递归 链表 双指针 👍 377 👎 0
//

package com.think.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CongWeiDaoTouDaYinLianBiaoLcof {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    public static void main(String[] args) {
        Solution solution = new CongWeiDaoTouDaYinLianBiaoLcof().new Solution();
        solution.reversePrint(new ListNode(1));
    }
//leetcode submit region begin(Prohibit modification and deletion)



    class Solution {
        // 递归
        public int[] reversePrint(ListNode head) {
            ArrayList<Integer> array = new ArrayList<>();
            getNum(array, head);
            int[] result = array.stream().mapToInt(Integer::intValue).toArray();
            return result;
        }

        public void getNum(List<Integer> array, ListNode node){
            if(node == null){
                return;
            }
            getNum(array, node.next);
            array.add(node.val);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

//    class Solution {
//        // 利用栈
//        public int[] reversePrint(ListNode head) {
//            Stack<ListNode> stack = new Stack<>();
//            int size = 0;
//            while(head != null){
//                stack.push(head);
//                head = head.next;
//                size++;
//            }
//            int[] result = new int[size];
//            size = 0;
//            while(!stack.isEmpty()){
//                result[size++] = stack.pop().val;
//            }
//            return result;
//        }
//    }
}
