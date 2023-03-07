package com.think.leetcode.editor.cn;

//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"ABCCED"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：board = [["a","b"],["c","d"]], word = "abcd"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n = board[i].length 
// 1 <= m, n <= 6 
// 1 <= word.length <= 15 
// board 和 word 仅由大小写英文字母组成 
// 
//
// 注意：本题与主站 79 题相同：https://leetcode-cn.com/problems/word-search/ 
// 👍 753 👎 0


public class JuZhenZhongDeLuJingLcof {
    public static void main(String[] args) {
        Solution solution = new JuZhenZhongDeLuJingLcof().new Solution();
        char[][] board = new char[][]{
            {'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}
        };
        String word = "SEE";
        System.out.println(solution.exist(board, word));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean exist(char[][] board, String word) {
            // 逐个遍历，从当前节点开始发散
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if(exist(board, word.toCharArray(), 0, i, j)){
                        return true;
                    }
                }
            }
            return false;
        }

        /**
         * 上下左右找一圈，走过的设置为true
         * 中止条件：超过边界 或 此格走过 或找到了全部单词 或当前单词不匹配
         * @param board
         * @param words
         * @param target    当前单词所在位置
         * @param row   当前行
         * @param col   当前列
         * @return
         */
        private boolean exist(char[][] board, char[] words, int target, int row, int col) {
            if(row >= board.length || col < 0 || col >= board[0].length || row < 0 || board[row][col] != words[target]){
                return false;
            }
            // 走到这代表已经找到了相等的元素；全部找到后递归出栈，return true
            if(target == words.length - 1){
                return true;
            }
            board[row][col] = '\0';
            boolean exist = (exist(board, words, target+1, row+1, col) || exist(board, words, target+1, row, col+1)
            || exist(board, words, target+1, row-1, col) || exist(board, words, target+1, row, col-1));
            // 递归逐个还原
            board[row][col] = words[target];

            return exist;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
