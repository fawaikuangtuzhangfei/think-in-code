package com.think.leetcode.editor.cn.entity;

import com.think.leetcode.editor.cn.ZhongJianErChaShuLcof;

import java.util.ArrayList;
import java.util.List;
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

    public static void front(TreeNode root){
        Stack<Object> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        stack.push(root);
        while(!stack.empty()){
            Object pop = stack.pop();
            if(pop instanceof Integer){
                // 已访问

            }else{
                // 未访问
                TreeNode node = (TreeNode)pop;
                System.out.println(node.val);
                stack.push(node.val);
                if(node.right != null){
                    stack.push(node.right);
                }
                if(node.right != null){
                    stack.push(node.right);
                }
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
