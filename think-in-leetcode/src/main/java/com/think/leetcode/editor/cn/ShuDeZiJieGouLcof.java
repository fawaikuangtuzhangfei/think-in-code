package com.think.leetcode.editor.cn;

//输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构) 
//
// B是A的子结构， 即 A中有出现和B相同的结构和节点值。 
//
// 例如: 
//给定的树 A: 
//
// 3 
// / \ 
// 4 5 
// / \ 
// 1 2 
//给定的树 B： 
//
// 4 
// / 
// 1 
//返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。 
//
// 示例 1： 
//
// 输入：A = [1,2,3], B = [3,1]
//输出：false
// 
//
// 示例 2： 
//
// 输入：A = [3,4,5,1,2], B = [4,1]
//输出：true 
//
// 限制： 
//
// 0 <= 节点个数 <= 10000 
// 👍 750 👎 0


public class ShuDeZiJieGouLcof {
    public static void main(String[] args) {
        Solution solution = new ShuDeZiJieGouLcof().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 递归深度遍历
     */
    class Solution {
        public boolean isSubStructure(TreeNode a, TreeNode b) {
            if(a == null || b == null ){
                return false;
            }
            return isSubStructure(a.left, b) || isSubStructure(a.right, b) ||  match(a, b);
        }

        public boolean match(TreeNode a, TreeNode b){
            // 树b完事了
            if(b == null){
                return true;
            }
            // 树a还没遍历完
            if (a == null) {
                return false;
            }
            if(a.val != b.val){
                return false;
            }
            // 看看左右子树是否相等
            return match(a.left, b.left) && match(a.right, b.right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
