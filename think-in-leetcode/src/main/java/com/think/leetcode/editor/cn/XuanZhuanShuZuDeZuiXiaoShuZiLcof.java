package com.think.leetcode.editor.cn;

//把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 
//
// 给你一个可能存在 重复 元素值的数组 numbers ，它原来是一个升序排列的数组，并按上述情形进行了一次旋转。请返回旋转数组的最小元素。例如，数组 [3
//,4,5,1,2] 为 [1,2,3,4,5] 的一次旋转，该数组的最小值为 1。 
//
// 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2],
//..., a[n-2]] 。
//
// 
//
// 示例 1： 
//
// 
//输入：numbers = [3,4,5,1,2]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：numbers = [2,2,2,0,1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// n == numbers.length
// 1 <= n <= 5000
// -5000 <= numbers[i] <= 5000 
// numbers 原来是一个升序排序的数组，并进行了 1 至 n 次旋转
// 
//
// 注意：本题与主站 154 题相同：https://leetcode-cn.com/problems/find-minimum-in-rotated-
//sorted-array-ii/ 
// 👍 772 👎 0


public class XuanZhuanShuZuDeZuiXiaoShuZiLcof {
    public static void main(String[] args) {
        Solution solution = new XuanZhuanShuZuDeZuiXiaoShuZiLcof().new Solution();
        System.out.println(solution.minArray(new int[]{2, 2, 2, 0, 1}));
    }

    /**
     * 二分法
     * i,j分别是开头和结尾
     * (i+j)/2 = m 中间节点
     * <p>
     * 如果:
     * 1 3 5
     * 5 1 3
     * 3 5 1
     * <p>
     * 1 1 2
     * num[m]>num[j]   则节点在右侧且不包含此节点 i=m+1 j=j
     * num[m]<num[j]   则节点在左侧 i=i j=m
     * num[m]=num[j]   则继续缩小范围 j=j-1
     * <p>
     * 中止条件 i>j
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minArray(int[] numbers) {
            int i = 0;
            int j = numbers.length - 1;
            while(i<j){
                int m = (i+j)/2;
                if(numbers[m] > numbers[j]){
                    i = m + 1;
                }else if(numbers[m] < numbers[j]){
                    j = m;
                }else{
                    j--;
                }
            }
            return numbers[i];
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}

/**
 * O(n)
 * 17:51	info
 * 解答成功:
 * 执行耗时:0 ms,击败了100.00% 的Java用户
 * 内存消耗:41.2 MB,击败了55.35% 的Java用户
 */
/*class Solution {
    public int minArray(int[] numbers) {
        if(numbers.length <= 0){
            return 0;
        }
        int preNum = numbers[0];
        int result = 5001;
        for (int i = 1; i < numbers.length; i++) {
            if(numbers[i] < preNum){
                result = numbers[i];
                break;
            }
            preNum = numbers[i];
        }
        if(result > 5000){
            return numbers[0];
        }
        return result;
    }
}*/
