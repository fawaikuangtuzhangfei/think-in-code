package com.think.leetcode.editor.cn.entity;

import com.think.leetcode.editor.cn.ZhongJianErChaShuLcof;

import java.util.Stack;

/**
 * 树
 * @author yechaoa
 * @date 2023-02-22 14:13
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) { val = x; }

    public static void main(String[] args) {
        ZhongJianErChaShuLcof.Solution solution = new ZhongJianErChaShuLcof().new Solution();
        int[] preOrder = new int[]{3,9,20,15,7};
        int[] inorder = new int[]{9,3,15,20,7};
        TreeNode root = solution.buildTree(preOrder, inorder);
//        ergodic(root);
        System.out.println(dfs(root));
    }

    /**
     * 深度遍历
     * @param root  根节点
     * @return
     */
    public static boolean dfs(TreeNode root){
        if(root == null){
            return false;
        }
        if(root.val == 11){
            return true;
        }
        return dfs(root.left) || dfs(root.right);
    }

    /**
     * 二色标记法:
     * 白节点=未访问，灰节点=已访问，不断弹栈
     * 1.遇到白节点，置为灰，将其左右子树压栈
     * 2.遇到灰节点，打印
     * @param root  根节点
     */
    public static void ergodic(TreeNode root){
        Stack<Object> stack = new Stack<>();
        stack.push(root);
        while(!stack.empty()){
            Object pop = stack.pop();
            if(pop instanceof Integer){
                // 已访问
                System.out.println(pop);
            }else{
                // 未访问
                TreeNode node = (TreeNode)pop;
                if(node.right != null){
                    stack.push(node.right);
                }
                if(node.left != null){
                    stack.push(node.left);
                }
                stack.push(node.val);
            }
        }

    }

}
