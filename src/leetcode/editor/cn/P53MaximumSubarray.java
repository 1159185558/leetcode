//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出：6
//解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：0
// 
//
// 示例 4： 
//
// 
//输入：nums = [-1]
//输出：-1
// 
//
// 示例 5： 
//
// 
//输入：nums = [-100000]
//输出：-100000
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 104 
// -105 <= nums[i] <= 105 
// 
//
// 
//
// 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。 
// Related Topics 数组 分治算法 动态规划 
// 👍 3151 👎 0


package leetcode.editor.cn;

//Java：最大子序和

/**
 * 对于一般动态规划问题，题目问你什么就设什么，确定后的dp函数要保证无后效性
 * 即把不确定的因素确定下来，在本题目中连续子数组，每个元素无法确定是否应该选择，
 * 此时我们设dp函数为以i结尾的最大连续数组和，把元素i确定下来（必须选择），这样便于我们写出状态转移方程。
 */
public class P53MaximumSubarray {
    public static void main(String[] args) {
        Solution solution = new P53MaximumSubarray().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSubArray(int[] nums) {
            int[] dp = new int[nums.length];
            //base case
            dp[0] = nums[0];
            int max = dp[0];
            for (int i = 1; i < nums.length; i++) {
                //状态转移方程
                dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
                max = Math.max(max, dp[i]);
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}