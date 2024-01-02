package com.think.leetcode.editor.cn;

//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 请注意 ，必须在不复制数组的情况下原地对数组进行操作。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [0,1,0,3,12]
//输出: [1,3,12,0,0]
// 
//
// 示例 2: 
//
// 
//输入: nums = [0]
//输出: [0] 
//
// 
//
// 提示: 
// 
//
// 
// 1 <= nums.length <= 10⁴ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 
//
// 
//
// 进阶：你能尽量减少完成的操作次数吗？ 
//
// Related Topics数组 | 双指针 
//
// 👍 2274, 👎 0 
//
//
//
//

  

public class MoveZeroes{
  public static void main(String[] args) {
       Solution solution = new MoveZeroes().new Solution();
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
      // 题目相当于 27题 移动元素=把所有的0都移除，然后把后面的都赋值为0
    public void moveZeroes(int[] nums) {
        int fast = 0,slow = 0;
        while (fast < nums.length){
            if(nums[fast] != 0){
                nums[slow++] = nums[fast];
            }
            fast++;
        }
        while (slow < nums.length){
            nums[slow++] = 0;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}