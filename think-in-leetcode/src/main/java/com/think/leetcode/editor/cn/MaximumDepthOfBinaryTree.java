package com.think.leetcode.editor.cn;

//给定一个二叉树 root ，返回其最大深度。 
//
// 二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：3
// 
//
// 示例 2： 
//
// 
//输入：root = [1,null,2]
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数量在 [0, 10⁴] 区间内。 
// -100 <= Node.val <= 100 
// 
//
// Related Topics树 | 深度优先搜索 | 广度优先搜索 | 二叉树 
//
// 👍 1767, 👎 0 
//
//
//
//



public class MaximumDepthOfBinaryTree{
  public static void main(String[] args) {
       Solution solution = new MaximumDepthOfBinaryTree().new Solution();
  }
  //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    /**
     * 分解-由子树获取到最大
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        // 一直到叶子节点 +1代表根节点自己
        int max = Math.max(leftDepth, rightDepth) + 1;

        return max;
    }
    // int depth = 0;
    // int max = 0;
    //
    // public int maxDepth(TreeNode root) {
    //     if(root == null){
    //         return 0;
    //     }
    //
    //     traverse(root);
    //     return max;
    // }
    //
    // /**
    //  * 前序=节点进入的时刻
    //  * 后序=节点离开的时刻
    //  * @param root
    //  */
    // public void traverse(TreeNode root){
    //     if(root == null){
    //         return;
    //     }
    //     depth++;
    //     traverse(root.left);
    //     traverse(root.right);
    //     // 遍历到底部叶子节点了，看看哪个更大
    //     if(root.left == null && root.right == null){
    //         max = Math.max(max, depth);
    //     }
    //     // 回溯
    //     depth--;
    // }
}
//leetcode submit region end(Prohibit modification and deletion)

}
