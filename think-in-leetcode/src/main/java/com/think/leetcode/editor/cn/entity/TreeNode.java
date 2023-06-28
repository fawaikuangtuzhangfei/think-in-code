package com.think.leetcode.editor.cn.entity;

import com.think.leetcode.editor.cn.ZhongJianErChaShuLcof;

import java.util.Stack;

/**
 * @author yechaoa
 * @date 2023-02-22 14:13
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) { val = x; }

    /**
     * 二色标记法:
     * 白节点=未访问，灰节点=已访问，不断弹栈
     * 1.遇到白节点，置为灰，将其左右子树压栈
     * 2.遇到灰节点，打印
     * @param root  根节点
     */
    public static void front(TreeNode root){
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

    public static void main(String[] args) {
        ZhongJianErChaShuLcof.Solution solution = new ZhongJianErChaShuLcof().new Solution();
        int[] preOrder = new int[]{3,9,20,15,7};
        int[] inorder = new int[]{9,3,15,20,7};
        front(solution.buildTree(preOrder, inorder));
    }
}
