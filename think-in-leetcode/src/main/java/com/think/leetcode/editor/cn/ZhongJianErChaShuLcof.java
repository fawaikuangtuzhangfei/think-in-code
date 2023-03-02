package com.think.leetcode.editor.cn; 

//<p>输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。</p>
//
//<p>假设输入的前序遍历和中序遍历的结果中都不含重复的数字。</p>
//
//<p> </p>
//
//<p><strong>示例 1:</strong></p>
//<img alt="" src="https://assets.leetcode.com/uploads/2021/02/19/tree.jpg" />
//<pre>
//<strong>Input:</strong> preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//<strong>Output:</strong> [3,9,20,null,null,15,7]
// 先序 根左右
// 中序 左根右
// 后序 左右根
//</pre>
//
//<p><strong>示例 2:</strong></p>
//
//<pre>
//<strong>Input:</strong> preorder = [-1], inorder = [-1]
//<strong>Output:</strong> [-1]
//</pre>
//
//<p> </p>
//
//<p><strong>限制：</strong></p>
//
//<p><code>0 <= 节点个数 <= 5000</code></p>
//
//<p> </p>
//
//<p><strong>注意</strong>：本题与主站 105 题重复：<a href="https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/">https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/</a></p>
//<div><li>👍 995</li><li>👎 0</li></div>

import com.think.leetcode.editor.cn.entity.TreeNode;

public class ZhongJianErChaShuLcof{
    public static void main(String[] args) {
        Solution solution = new ZhongJianErChaShuLcof().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = new TreeNode(preorder[0]);
        // 先序 根左右 中序 左右根

        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
