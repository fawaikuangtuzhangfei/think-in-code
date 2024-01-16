package com.think.leetcode.editor.cn.entity;

import com.think.leetcode.editor.cn.ZhongJianErChaShuLcof;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
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
        traverse(root);
       ergodic(root);
//        System.out.println(dfs(root));
//        bfs(root);
//         System.out.println(serialize(null));
//         bfs(deserialize(serialize(root)));
    }

    /**
     * 递归调用
     * 前序=节点进入的时刻
     * 后序=节点离开的时刻
     * @param root
     */
    public static void traverse(TreeNode root){
        if(root == null){
            return;
        }
        System.out.println(root.val);
        // 前序遍历
        traverse(root.left);
        // 中序遍历
        traverse(root.right);
        // 后序遍历
    }

    public static String serialize(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode current = queue.poll();
            if(current == null){
                result.add(null);
                continue;
            }
            result.add(current.val);
            queue.offer(current.left);
            queue.offer(current.right);
        }
        return result.toString();
    }

    public static TreeNode deserialize(String data) {
        if("[null]".equals(data)){
            return null;
        }
        data = data.replace("[", "").replace("]", "").replaceAll(" ", "");
        String[] split = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(split[0]));
        int index = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode current = queue.poll();
            if(current == null){
                continue;
            }
            String left = split[index++];
            if("null".equals(left)){
                current.left = null;
            }else{
                current.left = new TreeNode(Integer.parseInt(left));
            }
            String right = split[index++];
            if("null".equals(right)){
                current.right = null;
            }else{
                current.right = new TreeNode(Integer.parseInt(right));
            }

            queue.offer(current.left);
            queue.offer(current.right);
        }
        return root;
    }

    /**
     * 广度遍历
     * @param root  根节点
     */
    public static void bfs(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            System.out.println(poll.val);
            if(poll.left != null){
                queue.offer(poll.left);
            }
            if(poll.right != null){
                queue.offer(poll.right);
            }
        }
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

