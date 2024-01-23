package com.think.leetcode.editor.cn;

//给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。 
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// nums 是一个非递减数组 
// -10⁹ <= target <= 10⁹ 
// 
//
// Related Topics数组 | 二分查找 
//
// 👍 2608, 👎 0 
//
//
//
//

  

public class FindFirstAndLastPositionOfElementInSortedArray{
  public static void main(String[] args) {
       Solution solution = new FindFirstAndLastPositionOfElementInSortedArray().new Solution();
  }
  //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * //输入：nums = [5,7,7,8,8,10], target = 8
     * //输出：[3,4]
     * 1.不在数组范围内 则返回 -1 -1
     * eg：1,2,3 target=4    1,2,3 target=0
     * 2.在数组范围内，且存在则返回对应的 [3,4]
     * [5,7,7,8,8,10], target = 8
     * 3.在数组范围内，但是不存在 返回 -1 -1
     * eg：1,2,4 target=3
     */
    class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0){
            return new int[]{-1, -1};
        }
        int searchLeft = searchLeft(nums, target);
        int searchRight = searchRight(nums, target);
        //不在数组范围内 则返回 -1 -1
        if(searchLeft == -2 || searchRight == -2){
            return new int[]{-1, -1};
        }
        // 在数组范围内，且存在则返回对应的 [3,4]
        if(searchRight - searchLeft > 1){
            return new int[]{searchLeft + 1, searchRight - 1 };
        }

        return new int[]{-1, -1};
    }

      public int searchLeft(int[] nums, int target) {
          int left = 0, right = nums.length - 1;
          int mid;
          int leftResult = -2;
          // 二分查找边界（不包含此数）
          // nums = [1,3,4], target = 0
          while (left <= right) {
              mid = left + ((right - left) / 2);
              // 说明值在 left,mid,当等于时更新左边界
              if(nums[mid] >= target){
                  right = mid - 1;
                  leftResult = right;
              }else{
                  left = mid + 1;
              }
          }
          return leftResult;
      }

        public int searchRight(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            int mid;
            int rightResult = -2;
            // 二分查找右边界（不包含此数）
            // nums = [1,3,4], target = 5
            while (left <= right) {
                mid = left + ((right - left) / 2);
                // 说明值在 left,mid
                if(nums[mid] > target){
                    right = mid - 1;
                }else{
                    // 等于mid时
                    left = mid + 1;
                    rightResult = left;
                }
            }
            return rightResult;
        }


}
//leetcode submit region end(Prohibit modification and deletion)

}