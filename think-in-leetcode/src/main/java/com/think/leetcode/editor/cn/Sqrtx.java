package com.think.leetcode.editor.cn;

//给你一个非负整数 x ，计算并返回 x 的 算术平方根 。 
//
// 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。 
//
// 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 4
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：x = 8
//输出：2
//解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= x <= 2³¹ - 1 
// 
//
// Related Topics数学 | 二分查找 
//
// 👍 1502, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

  

public class Sqrtx{
    public static void main(String[] args) {
        Solution solution = new Sqrtx().new Solution();
    }
  //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 大于则向右
     * 等于则正好整除
     * 小于则可能是
     * 8/2=4
     * 4*4=16>8
     * 1+4=5/2=2 2*2=4 此时小于8则可能是答案
     */
    class Solution {
        public int mySqrt(int x) {
            if(x == 1 || x == 0){
                return x;
            }

            // 肯定不是0
            int left = 1;
            int right = x / 2;
            // 当left>right时，则right为答案
            while(left <= right){
                int mid = left + ((right - left) / 2);
                // 防止溢出用除法
                if(mid > x / mid){
                    right = mid-1;
                }else {
                    left = mid + 1;
                }
            }
            return right;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}