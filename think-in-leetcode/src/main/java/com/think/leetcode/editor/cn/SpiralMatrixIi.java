package com.think.leetcode.editor.cn;

//给你一个正整数 n ，生成一个包含 1 到 n² 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：n = 3
//输出：[[1,2,3],[8,9,4],[7,6,5]]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 
//
// Related Topics数组 | 矩阵 | 模拟 
//
// 👍 1242, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

  

public class SpiralMatrixIi{
    public static void main(String[] args) {
        Solution solution = new SpiralMatrixIi().new Solution();
        int[][] ints = solution.generateMatrix(4);
        for (int row = 0; row < ints.length; row++) {
            for (int col = 0; col < ints[row].length; col++) {
                System.out.println(ints[row][col]);
            }
        }
    }
  //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 顺着边去循环
     */
    class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int num = 1;

        int rowBegin = 0;
        int rowEnd = n - 1;
        int colBegin = 0;
        int colEnd = n - 1;

        while(num <= n * n){

            for (int i=colBegin; i <= colEnd; i++){
                result[rowBegin][i] = num++;
            }
            // 第一行已经循环完成了 不要了
            rowBegin++;

            for (int i=rowBegin; i <= rowEnd; i++){
                result[i][colEnd] = num++;
            }
            // 最后一列不要了
            colEnd--;

            for (int i=colEnd; i >= colBegin; i--){
                result[rowEnd][i] = num++;
            }
            // 最后一行不要了
            rowEnd--;

            for (int i=rowEnd; i >= rowBegin; i--){
                result[i][colBegin] = num++;
            }
            // 第一列不要了
            colBegin++;






        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}