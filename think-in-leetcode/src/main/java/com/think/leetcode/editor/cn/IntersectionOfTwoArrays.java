package com.think.leetcode.editor.cn;

// 349 两个数组的交集
// 给定两个数组，编写一个函数来计算它们的交集。
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2]
// 
//
// 示例 2： 
//
// 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[9,4] 
//
// 
//
// 说明： 
//
// 
// 输出结果中的每个元素一定是唯一的。 
// 我们可以不考虑输出结果的顺序。 
// 
// Related Topics 数组 哈希表 双指针 二分查找 排序 👍 432 👎 0

import java.util.*;

public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        Solution solution = new IntersectionOfTwoArrays().new Solution();

    }

    /**
     * 1.遍历较大数组，用Hash存储元素，遍历较小数组，O(1)查看是否存在
     * 2.先排序  然后通过双指针来控制
     *
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            Set<Integer> set = new HashSet<>();
            Set<Integer> set2 = new HashSet<>();
            for (int i = 0; i < nums1.length; i++) {
                set.add(nums1[i]);
            }
            for (int i = 0; i < nums2.length; i++) {
                if(set.contains(nums2[i])){
                    set2.add(nums2[i]);
                }
            }
            int[] result = new int[set2.size()];
            List<Integer> list = new ArrayList<>(set2);
            for (int i = 0; i < list.size(); i++) {
                result[i] = list.get(i);
            }
            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    class Solution2 {
        public int[] intersection(int[] nums1, int[] nums2) {
            if(nums1.length == 0 || nums2.length == 0){
                return null;
            }
            Arrays.sort(nums1);
            Arrays.sort(nums2);
            Set<Integer> set = new HashSet<>();
            int r = 0;
            int l = 0;
            while (r < nums1.length && l < nums2.length){
                if(nums1[r] == nums2[l]){
                    set.add(nums1[r]);
                    r++;
                    l++;
                }else if(nums1[r] < nums2[l]){
                    r++;
                }else{
                    l++;
                }
            }
            int[] result = new int[set.size()];
            List<Integer> list = new ArrayList<>(set);
            for (int i = 0; i < list.size(); i++) {
                result[i] = list.get(i);
            }
            return result;
        }
    }
}