package com.think.leetcode.editor.cn;

//输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。 
//
// 
//
// 示例 1： 
//
// 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 限制： 
//
// 
// 0 <= matrix.length <= 100 
// 0 <= matrix[i].length <= 100 
// 
//
// 注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/ 
// 👍 536 👎 0


public class ShunShiZhenDaYinJuZhenLcof {
    public static void main(String[] args) {
        Solution solution = new ShunShiZhenDaYinJuZhenLcof().new Solution();
        int[][] ints = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        solution.spiralOrder(ints);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 拧魔方 不断将要遍历的旋转90°
         * eg:[[1,2,3],[4,5,6],[7,8,9]]
         * [1,2,3,6,9,8,7,4,5]
         * 1,2,3 完成后旋转 变为
         * 6,9
         * 4,5
         * 7,8
         *
         * 6,9 完成后继续旋转 变为
         * 5,8
         * 4,7
         *
         * 截止条件=只剩一列
         */
        public int[] spiralOrder(int[][] matrix) {
            int ylength = matrix.length;
            if(ylength == 0){
                return new int[0];
            }
            int xlength = matrix[0].length;


            int[] result = new int[xlength * ylength];
            int index = 0;
            while (xlength > 0) {
                for (int i = 0; i < xlength; i++) {
                    result[index++] = matrix[0][i];
                }
                if(ylength == 1){
                    break;
                }
                // 旋转
                matrix = swap(matrix);
                ylength = matrix.length;
                xlength = matrix[0].length;
            }

            return result;
        }

        /**
         * 1,2,3
         * 4,5,6
         * 7,8,9
         */
        public int[][] swap(int[][] matrix){
            int xlength = matrix[0].length;
            int ylength = matrix.length;
            // 直接去掉第一行
            int[][] newMatrix = new int[xlength][ylength - 1];
            for (int i = 1; i < ylength; i++) {
                for (int j = xlength-1; j >= 0; j--) {
                    newMatrix[xlength-j-1][i-1] = matrix[i][j];
                }
            }
            return newMatrix;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
