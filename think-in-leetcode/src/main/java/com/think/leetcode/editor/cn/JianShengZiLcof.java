package com.think.leetcode.editor.cn;

//给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。
//请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18
//。 
//
// 示例 1： 
//
// 输入: 2
//输出: 1
//解释: 2 = 1 + 1, 1 × 1 = 1 
//
// 示例 2: 
//
// 输入: 10
//输出: 36
//解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36 
//
// 提示： 
//
// 
// 2 <= n <= 58 
// 
//
// 注意：本题与主站 343 题相同：https://leetcode-cn.com/problems/integer-break/ 
// 👍 560 👎 0


public class JianShengZiLcof {
    public static void main(String[] args) {
        Solution solution = new JianShengZiLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 数学推导结论：
         * 3>2>1
         * 最后一段是1，则将其中一个3拆为2+1 变成2*2
         * 最后一段是2
         * 最后一段是0
         */
        public int cuttingRope(int n) {
            if(n == 1){
                return 1;
            }
            if(n == 2){
                return 1;
            }
            if(n == 3){
                return 2;
            }
            int result;
            int count = n/3;
            int last = n%3;
            if(last == 1 && count > 0){
                count--;
                result = (int) (Math.pow(3, count) * 4);
            }else if(last == 0){
                result = (int) Math.pow(3, count);
            }else{
                result = (int) Math.pow(3, count) * last;
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
