package com.think.leetcode.editor.cn; 

//请实现一个函数用来匹配包含'. '和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）。在本题中，匹配
//是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配。 
//
// 示例 1: 
//
// 输入:
//s = "aa"
//p = "a"
//输出: false
//解释: "a" 无法匹配 "aa" 整个字符串。
// 
//
// 示例 2: 
//
// 输入:
//s = "aa"
//p = "a*"
//输出: true
//解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
// 
//
// 示例 3: 
//
// 输入:
//s = "ab"
//p = ".*"
//输出: true
//解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
// 
//
// 示例 4: 
//
// 输入:
//s = "aab"
//p = "c*a*b"
//输出: true
//解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
// 
//
// 示例 5: 
//
// 输入:
//s = "mississippi"
//p = "mis*is*p*."
//输出: false 
//
// 
// s 可能为空，且只包含从 a-z 的小写字母。 
// p 可能为空，且只包含从 a-z 的小写字母以及字符 . 和 *，无连续的 '*'。 
// 
//
// 注意：本题与主站 10 题相同：https://leetcode-cn.com/problems/regular-expression-matching/
// 
// 👍 536 👎 0


public class ZhengZeBiaoDaShiPiPeiLcof{
    public static void main(String[] args) {
        Solution solution = new ZhengZeBiaoDaShiPiPeiLcof().new Solution();
        System.out.println(solution.isMatch("aa", "a.*c"));
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 如果第二位是*
     * 1、模式后移2字符，相当于x*被忽略；
     * 2、字符串后移1字符，模式后移2字符=只匹配了一次
     * 3、字符串后移1字符，模式不变，即继续匹配字符下一位，因为*可以匹配多位；=不停的匹配当前字符
     *
     * 正常字符串正常匹配，都后移一位
     * 如果是. 则都后移一位
     * 不匹配，直接false
     *
     * 第二位不是* 正常比较即可
     *
     */
    public boolean isMatch(String str, String pattern) {
        int strIndex = 0;
        int patternIndex = 0;
        return match(str.toCharArray(), pattern.toCharArray(), strIndex, patternIndex);
    }

    private boolean match(char[] str, char[] pattern, int strIndex, int patternIndex) {
        if(strIndex == str.length && patternIndex == pattern.length){
            return true;
        }
        if(strIndex != str.length && patternIndex == pattern.length){
            return false;
        }
        if(strIndex > str.length || patternIndex > pattern.length){
            return false;
        }
        // 第二个字符是*
        if(patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*'){
            // 第一个字符是否匹配或者等于.
            if(strIndex < str.length && str[strIndex] == pattern[patternIndex] || pattern[patternIndex] == '.'){
                // 模式后移2字符，相当于x*被忽略；
                return match(str, pattern, strIndex, patternIndex + 2) ||
                        // 字符串后移1字符，模式后移2字符=只匹配了一次
                        match(str, pattern, strIndex + 1, patternIndex + 2) ||
                        // 字符串后移1字符，模式不变，即继续匹配字符下一位，因为*可以匹配多位；=不停的匹配当前字符
                        match(str, pattern, strIndex + 1, patternIndex);
            }else{
                // 没匹配上直接到下一个模式
                return match(str, pattern, strIndex, patternIndex + 2);
            }
        }
        // 第二个字符不是*
        if(strIndex < str.length && str[strIndex] == pattern[patternIndex] || pattern[patternIndex] == '.'){
            return match(str, pattern, strIndex + 1, patternIndex + 1);
        }
        return false;
    }
}


//leetcode submit region end(Prohibit modification and deletion)

}
