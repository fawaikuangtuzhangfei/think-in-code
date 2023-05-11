package com.think.leetcode.editor.cn;

//实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xⁿ）。不得使用库函数，同时不需要考虑大数问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 2.00000, n = 10
//输出：1024.00000
// 
//
// 示例 2： 
//
// 
//输入：x = 2.10000, n = 3
//输出：9.26100 
//
// 示例 3： 
//
// 
//输入：x = 2.00000, n = -2
//输出：0.25000
//解释：2⁻² = 1/2² = 1/4 = 0.25 
//
// 
//
// 提示： 
//
// 
// -100.0 < x < 100.0 
// -2³¹ <= n <= 2³¹-1 
// -10⁴ <= xⁿ <= 10⁴ 
// 
//
// 
//
// 注意：本题与主站 50 题相同：https://leetcode-cn.com/problems/powx-n/ 
// 👍 415 👎 0


public class ShuZhiDeZhengShuCiFangLcof {
    public static void main(String[] args) {
        Solution solution = new ShuZhiDeZhengShuCiFangLcof().new Solution();
        solution.myPow(2, 2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 快速幂等
         * x4 = x2 * x2
         * x5 = x2* x2 * x
         */
        public double myPow(double x, int n) {
            if (n == 0 || x == 1) {
                return 1;
            }
            return n > 0 ? pow(x, n) : 1 / pow(x, n);
        }

        public double pow(double x, int n) {
            if (n == 0) {
                return 1;
            }
            double result = pow(x, n / 2) ;
            return n % 2 == 0? result * result : result * result * x;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
