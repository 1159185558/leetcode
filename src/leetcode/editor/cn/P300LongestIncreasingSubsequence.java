//给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。 
//
// 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序
//列。 
// 
//
// 示例 1： 
//
// 
//输入：nums = [10,9,2,5,3,7,101,18]
//输出：4
//解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,0,3,2,3]
//输出：4
// 
//
// 示例 3： 
//
// 
//输入：nums = [7,7,7,7,7,7,7]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2500 
// -104 <= nums[i] <= 104 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以设计时间复杂度为 O(n2) 的解决方案吗？ 
// 你能将算法的时间复杂度降低到 O(n log(n)) 吗? 
// 
// Related Topics 二分查找 动态规划 
// 👍 1543 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

//Java：最长递增子序列
public class P300LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Solution solution = new P300LongestIncreasingSubsequence().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * dp[i]为以i为结尾的最长递增子序列的长度，这样限定了元素i必须被选中
         * 最后遍历dp数组取最大值即可
         * @param nums
         * @return
         */
        public int lengthOfLIS(int[] nums) {
            int[] dp = new int[nums.length];
            //base case 初始设置为1
            Arrays.fill(dp, 1);
            int max = 1;
            for (int i = 0; i < nums.length; i++) {
                int tmp = nums[i];
                //对于每个tmp元素导致nums最长递增子序列是否加1，主要看小于tmp的元素下标j的max{dp[j]}+1
                //因此我们需要遍历元素i之前的所有元素
                for (int j = 0; j < i; j++) {
                    if (nums[j] < tmp) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
                max = Math.max(max, dp[i]);
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}