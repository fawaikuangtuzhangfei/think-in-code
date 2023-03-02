package com.think.leetcode.editor.cn;

//用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的
//功能。(若队列中没有元素，deleteHead 操作返回 -1 ) 
//
// 
//
// 示例 1： 
//
// 
//输入：
//["CQueue","appendTail","deleteHead","deleteHead","deleteHead"]
//[[],[3],[],[],[]]
//输出：[null,null,3,-1,-1]
// 
//
// 示例 2： 
//
// 
//输入：
//["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
//[[],[],[5],[2],[],[]]
//输出：[null,-1,null,null,5,2]
// 
//
// 提示： 栈先进后出、队列先进先出，添加时直接压入栈，弹出时，将第一个栈中的全部元素全部压入第二个栈，然后弹出第二个栈的元素
// 但是需要注意，当第二个栈中有元素代表直接弹出即可（还是队尾的那些元素）
//
// 
// 1 <= values <= 10000 
// 最多会对 appendTail、deleteHead 进行 10000 次调用 
// 
// 👍 707 👎 0


import java.util.Stack;

public class YongLiangGeZhanShiXianDuiLieLcof {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class CQueue {

        private Stack<Integer> head;
        private Stack<Integer> tail;

        public CQueue() {
            head = new Stack<>();
            tail = new Stack<>();
        }

        public void appendTail(int value) {
            head.push(value);
        }

        public int deleteHead() {
            if (tail.empty()) {
                if (head.empty()) {
                    return -1;
                } else {
                    while (!head.empty()) {
                        tail.push(head.pop());
                    }
                }
            }
            return tail.pop();

        }
    }

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
//leetcode submit region end(Prohibit modification and deletion)

}
