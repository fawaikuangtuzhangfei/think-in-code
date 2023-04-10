package com.think.leetcode.editor.cn; 

//给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m - 1]
// 。请问 k[0]*k[1]*...*k[m - 1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘
//积是18。 
//
// 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。 
//
// 
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
// 
//
// 提示： 
//
// 
// 2 <= n <= 1000 
// 
//
// 注意：本题与主站 343 题相同：https://leetcode-cn.com/problems/integer-break/ 
// 👍 249 👎 0


public class JianShengZiIiLcof{
    public static void main(String[] args) {
        Solution solution = new JianShengZiIiLcof().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        // 有3取3 剩2变4（3变成2，2*2）
    public int cuttingRope(int n) {
        if(n == 2){
            return 1;
        }
        if(n == 3){
            return 2;
        }
        int count = n/3;
        int last = n%3;
        long result = 1;
        // eg 10 3 3 4 > 3 3 3 1
        if(last == 1 && count > 0){
            count--;
            last++;
        }else if(last == 2){
            last = 1;
        }
        for (int i = count; i > 0; i--) {
            result *= 3;
            result %= 1000000007;
        }
        for (int i = last; i > 0; i--) {
            result *= 2;
            result %= 1000000007;
        }
        return (int) result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
