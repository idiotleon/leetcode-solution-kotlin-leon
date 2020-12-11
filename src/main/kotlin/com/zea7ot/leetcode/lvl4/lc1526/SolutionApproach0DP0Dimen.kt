/**
 * https://leetcode.com/problems/minimum-number-of-increments-on-subarrays-to-form-a-target-array/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/minimum-number-of-increments-on-subarrays-to-form-a-target-array/discuss/754674/JavaC%2B%2BPython-Comparison-of-Consecutive-Elements
 *  https://leetcode.com/problems/minimum-number-of-increments-on-subarrays-to-form-a-target-array/discuss/754623/Detailed-Explanation
 */
package com.zea7ot.leetcode.lvl4.lc1526

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP0Dimen {
    fun minNumberOperations(target: IntArray): Int {
        // not used
        // val nNums = target.size

        var ans = 0
        var prev = 0
        for (cur in target) {
            ans += maxOf(cur - prev, 0)
            prev = cur
        }

        return ans
    }
}