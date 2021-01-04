/**
 * https://leetcode.com/problems/check-if-a-string-contains-all-binary-codes-of-size-k/
 *
 * Time Complexity:     O((`lenS` - `k`) * `k`)
 * Space Complexity:    O(2 ^ `k` * `k`)
 *
 * References:
 *  https://leetcode.com/problems/check-if-a-string-contains-all-binary-codes-of-size-k/discuss/660546/JavaPython-3-4-and-1-liners-clean-codes-using-set-w-brief-explanation-and-analysis.
 */
package com.zea7ot.leetcode.lvl3.lc1461

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0SlidingWindow1 {
    fun hasAllCodes(str: String, k: Int): Boolean {
        val lenS = str.length

        val seen = HashSet<String>()
        for (idx in k..lenS) {
            if (seen.size >= 1 shl k) break
            seen.add(str.substring(idx - k, idx))
        }

        return seen.size == 1 shl k
    }
}