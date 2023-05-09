package com.think.leetcode.editor.cn;

//地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一
//格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但
//它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？ 
//
// 
//
// 示例 1： 
//
// 输入：m = 2, n = 3, k = 1
//输出：3
// 
//
// 示例 2： 
//
// 输入：m = 3, n = 1, k = 0
//输出：1
// 
//
// 提示： 
//
// 
// 1 <= n,m <= 100 
// 0 <= k <= 20 
// 
// 👍 632 👎 0


public class JiQiRenDeYunDongFanWeiLcof {
    public static void main(String[] args) {
        Solution solution = new JiQiRenDeYunDongFanWeiLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 深度优先遍历，走过就设置flag=true，到达边界则中止
         */
        public int movingCount(int m, int n, int k) {
            boolean[][] map = new boolean[m][n];
            return move(map, 0, 0, k);
        }

        public int move(boolean[][] map, int row, int line, int k){
            if(row >= map.length || line >= map[0].length || row < 0 || line < 0){
                return 0;
            }
            if(map[row][line] || (sum(row) + sum(line)) > k){
                return 0;
            }
            map[row][line] = true;
            return move(map, row, line+1, k) + move(map, row, line-1, k) + move(map, row+1, line, k) + move(map, row-1, line, k) + 1;
        }

        public int sum(int num){
            int result = 0;
            while (num != 0){
                result += num % 10;
                num /= 10;
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
