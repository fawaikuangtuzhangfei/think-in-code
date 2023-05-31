package com.think.leetcode.editor.cn;

//请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。 
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。 
//
// 1 
// / \ 
// 2 2 
// / \ / \ 
//3 4 4 3 
//但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的: 
//
// 1 
// / \ 
// 2 2 
// \ \ 
// 3 3 
//
// 
//
// 示例 1： 
//
// 输入：root = [1,2,2,3,4,4,3]
//输出：true
// 
//
// 示例 2： 
//
// 输入：root = [1,2,2,null,3,null,3]
//输出：false 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 1000 
//
// 注意：本题与主站 101 题相同：https://leetcode-cn.com/problems/symmetric-tree/ 
// 👍 450 👎 0


public class DuiChengDeErChaShuLcof {
    public static void main(String[] args) {
        Solution solution = new DuiChengDeErChaShuLcof().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public boolean isSymmetric(TreeNode root) {
            if(root == null){
                return true;
            }
            return isSymmetricHelper(root.left, root.right);
        }

        public boolean isSymmetricHelper(TreeNode left, TreeNode right){
            if(left == null && right == null){
                return true;
            }
            if(left == null || right == null){
                return false;
            }
            if(left.val != right.val){
                return false;
            }
            return isSymmetricHelper(left.left, right.right) && isSymmetricHelper(right.left, left.right);
        }

    }

    //leetcode submit region end(Prohibit modification and deletion)
    class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }

}
