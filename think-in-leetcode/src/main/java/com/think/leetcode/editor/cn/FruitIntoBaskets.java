package com.think.leetcode.editor.cn;

//你正在探访一家农场，农场从左到右种植了一排果树。这些树用一个整数数组 fruits 表示，其中 fruits[i] 是第 i 棵树上的水果 种类 。 
//
// 你想要尽可能多地收集水果。然而，农场的主人设定了一些严格的规矩，你必须按照要求采摘水果： 
//
// 
// 你只有 两个 篮子，并且每个篮子只能装 单一类型 的水果。每个篮子能够装的水果总量没有限制。 
// 你可以选择任意一棵树开始采摘，你必须从 每棵 树（包括开始采摘的树）上 恰好摘一个水果 。采摘的水果应当符合篮子中的水果类型。每采摘一次，你将会向右移动到
//下一棵树，并继续采摘。 
// 一旦你走到某棵树前，但水果不符合篮子的水果类型，那么就必须停止采摘。 
// 
//
// 给你一个整数数组 fruits ，返回你可以收集的水果的 最大 数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：fruits = [1,2,1]
//输出：3
//解释：可以采摘全部 3 棵树。
// 
//
// 示例 2： 
//
// 
//输入：fruits = [0,1,2,2]
//输出：3
//解释：可以采摘 [1,2,2] 这三棵树。
//如果从第一棵树开始采摘，则只能采摘 [0,1] 这两棵树。
// 
//
// 示例 3： 
//
// 
//输入：fruits = [1,2,3,2,2]
//输出：4
//解释：可以采摘 [2,3,2,2] 这四棵树。
//如果从第一棵树开始采摘，则只能采摘 [1,2] 这两棵树。
// 
//
// 示例 4： 
//
// 
//输入：fruits = [3,3,3,1,2,1,1,2,3,3,4]
//输出：5
//解释：可以采摘 [1,2,1,1,2] 这五棵树。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= fruits.length <= 10⁵ 
// 0 <= fruits[i] < fruits.length 
// 
//
// Related Topics数组 | 哈希表 | 滑动窗口 
//
// 👍 613, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


import java.util.HashMap;
import java.util.Map;

public class FruitIntoBaskets{
    public static void main(String[] args) {
        Solution solution = new FruitIntoBaskets().new Solution();
        System.out.println(solution.totalFruit(new int[]{1, 2, 1}));
    }
  //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 求最长的子串
     */
    class Solution {
    public int totalFruit(int[] fruits) {
        int left = 0;
        // key = 水果 value = 水果出现的次数
        Map<Integer, Integer> fruitHash = new HashMap<>();
        int result = 0;
        // 0,1,2,2     3
        for (int right = 0; right < fruits.length; right++) {
            int fruitRight = fruits[right];
            fruitHash.put(fruitRight, fruitHash.getOrDefault(fruitRight, 0) + 1);
            while(fruitHash.size() > 2){
                int fruitLeft = fruits[left];
                fruitHash.put(fruitLeft, fruitHash.get(fruitLeft) - 1);
                left++;
                // 完全没有了就把key移除掉
                if(fruitHash.get(fruitLeft) == 0){
                    fruitHash.remove(fruitLeft);
                }
            }
            result = Math.max(result, right - left + 1);
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}