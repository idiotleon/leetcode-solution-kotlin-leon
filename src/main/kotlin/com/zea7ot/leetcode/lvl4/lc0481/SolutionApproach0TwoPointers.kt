/**
 * https://leetcode.com/problems/magical-string/
 *
 * Time Complexity:     O(`n`)
 * Space Complexity:    O(`n`)
 *
 * References:
 *  https://leetcode.com/problems/magical-string/discuss/96413/Simple-Java-solution-using-one-array-and-two-pointers
 */
package com.zea7ot.leetcode.lvl4.lc0481

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0TwoPointers {
    fun magicalString(n: Int): Int {
        if (n <= 0) return 0
        if (n <= 3) return 1

        val nums = IntArray(n + 1) { 0 }.also {
            it[0] = 1
            it[1] = 2
            it[2] = 2
        }

        var lo = 2
        var hi = 3
        var num = 1
        var ans = 1

        while (hi < n) {
            for (repeat in 0 until nums[lo]) {
                nums[hi] = num
                if (num == 1 && hi < n) ++ans
                ++hi
            }

            num = num xor 3
            ++lo
        }

        return ans
    }
}