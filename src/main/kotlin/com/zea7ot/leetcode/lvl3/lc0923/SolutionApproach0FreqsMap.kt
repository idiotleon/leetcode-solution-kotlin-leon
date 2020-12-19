/**
 * https://leetcode.com/problems/3sum-with-multiplicity/
 *
 * Time Complexity:     O(`totalNums` ^ 2)
 * Space Complexity:    O(`totalNums` ^ 2)
 *
 * References:
 *  https://leetcode.com/problems/3sum-with-multiplicity/discuss/181128/10-lines-Super-Super-Easy-Java-Solution
 */
package com.zea7ot.leetcode.lvl3.lc0923

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0FreqsMap {
    class Solution {
        private companion object {
            private const val MOD = 1e9.toInt() + 7
        }

        fun threeSumMulti(nums: IntArray, target: Int): Int {
            // not used
            // val totalNums = nums.size

            val freqs = HashMap<Int, Int>()

            var count = 0

            for (hi in nums.indices) {
                count += (freqs[target - nums[hi]] ?: 0) % MOD
                // cannot be skipped
                count %= MOD

                for (lo in 0 until hi) {
                    val twoSum = nums[lo] + nums[hi]
                    freqs[twoSum] = (freqs[twoSum] ?: 0) + 1
                }
            }

            return count
        }
    }
}