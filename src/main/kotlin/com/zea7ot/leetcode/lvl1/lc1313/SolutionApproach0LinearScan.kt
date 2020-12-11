/**
 * https://leetcode.com/problems/decompress-run-length-encoded-list/
 *
 * Time Complexity:     O(`nums[0]` + `nums[2]` + ... + `nums[]`)
 * Space Complexity:    O(`nums[0]` + `nums[2]` + ... + `nums[]`)
 *
 * References:
 *  https://leetcode.com/problems/decompress-run-length-encoded-list/discuss/477034/JavaPython-3-Straight-forward-51-line-codes-w-brief-analysis.
 */
package com.zea7ot.leetcode.lvl1.lc1313

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0LinearScan {
    fun decompressRLElist(nums: IntArray): IntArray {
        val ans = ArrayList<Int>()
        for (idx in nums.indices step 2) {
            for (repeat in 0 until nums[idx]) {
                ans.add(nums[idx + 1])
            }
        }

        return ans.toIntArray()
    }
}