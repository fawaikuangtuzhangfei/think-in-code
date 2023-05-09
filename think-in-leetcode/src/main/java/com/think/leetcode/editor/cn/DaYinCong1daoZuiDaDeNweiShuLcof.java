package com.think.leetcode.editor.cn;

//输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。 
//
// 示例 1: 
//
// 输入: n = 1
//输出: [1,2,3,4,5,6,7,8,9]
// 
//
// 
//
// 说明： 
//
// 
// 用返回一个整数列表来代替打印 
// n 为正整数 
// 
// 👍 291 👎 0


public class DaYinCong1daoZuiDaDeNweiShuLcof {
    public static void main(String[] args) {
        Solution solution = new DaYinCong1daoZuiDaDeNweiShuLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 10的n次方-1
         */
        public int[] printNumbers(int n) {
            double pow = Math.pow(10, n);
            int[] result = new int[(int) pow - 1];
            int index = 0;
            while (index < pow - 1) {
                result[index++] = index;
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
