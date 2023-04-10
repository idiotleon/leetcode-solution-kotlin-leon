package com.idiotleon.leetcode.lvl4.lc1546

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/maximum-number-of-non-overlapping-subarrays-with-sum-equals-target/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(`nNums`)
 *
 * Reference:
 * https://leetcode.com/problems/maximum-number-of-non-overlapping-subarrays-with-sum-equals-target/discuss/780882/Java-14-lines-Greedy-PrefixSum-with-line-by-line-explanation-easy-to-understand/648238
 * https://leetcode.com/problems/maximum-number-of-non-overlapping-subarrays-with-sum-equals-target/discuss/780882/Java-14-lines-Greedy-PrefixSum-with-line-by-line-explanation-easy-to-understand
 * https://leetcode.com/problems/maximum-number-of-non-overlapping-subarrays-with-sum-equals-target/discuss/781047/Java-Greedy-Approach-Explained-HashMap-and-Prefix-Sum
 */
@Suppress(UNUSED)
class SolutionApproach0Greedy {
    fun maxNonOverlapping(nums: IntArray, target: Int): Int {
        // not used
        // val nNums = nums.size

        val set = HashSet<Int>()

        var count = 0
        var sum = 0

        for (num in nums) {
            sum += num

            if (sum == target || set.contains(sum - target)) {
                ++count
                sum = 0
                set.clear()
            } else {
                set.add(sum)
            }
        }

        return count
    }
}