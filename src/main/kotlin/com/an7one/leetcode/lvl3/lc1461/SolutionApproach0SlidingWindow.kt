/**
 * https://leetcode.com/problems/check-if-a-string-contains-all-binary-codes-of-size-k/
 *
 * Time Complexity:     O(`lenS`)
 * Space Complexity:    O(2 ^ `lenS`)
 *
 * References:
 *  https://leetcode.com/problems/check-if-a-string-contains-all-binary-codes-of-size-k/discuss/661480/C%2B%2B-Optimized-Sliding-Window
 */
package com.an7one.leetcode.lvl3.lc1461

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0SlidingWindow {
    fun hasAllCodes(str: String, k: Int): Boolean {
        // not used
        // val lenS = str.length

        if (k > 15) return false

        val range = 1 shl k

        val found = BooleanArray(range) { false }

        var num = 0
        val mask = range - 1
        var count = 0

        for (idx in str.indices) {
            num = mask and ((num shl 1) + (str[idx] - '0'))

            if (idx >= k - 1) {
                if (!found[num]) {
                    ++count
                }

                found[num] = true
            }
        }

        return count == range
    }
}