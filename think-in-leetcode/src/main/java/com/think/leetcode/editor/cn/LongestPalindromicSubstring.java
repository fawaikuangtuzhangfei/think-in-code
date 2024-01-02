package com.think.leetcode.editor.cn;

//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母组成 
// 
//
// Related Topics字符串 | 动态规划 
//
// 👍 7006, 👎 0 
//
//
//
//


public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            char[] chars = s.toCharArray();
            String result = "";
            for (int i = 0; i < chars.length; i++) {
                // 奇数长度，中点是同一个
                String result1 = palindrome(s, i, i);
                // 偶数长度，中点是相邻的两个
                String result2 = palindrome(s, i, i + 1);

                result = result.length() > result1.length()? result : result1;
                result = result.length() > result2.length()? result : result2;
            }

            return result;
        }

        /**
         * 从中间向两边扩散
         * @param s 字符串本身
         * @param l 向左移动的指针
         * @param r 向右移动的指针
         * @return  l~r 中最长的回文字符串
         */
        public String palindrome(String s, int l, int r) {
            while (r < s.length() && l >= 0 && s.charAt(l) == s.charAt(r)) {
                r++;
                l--;
            }
            return s.substring(l+1, r);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}