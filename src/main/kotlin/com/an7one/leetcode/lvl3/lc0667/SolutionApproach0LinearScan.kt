/**
 * https://leetcode.com/problems/beautiful-arrangement-ii/
 *
 * Time Complexity:     O(`n`)
 * Space Complexity:    O(`n`) / O(1)
 *
 * References:
 *  https://leetcode.com/problems/beautiful-arrangement-ii/discuss/106948/C++-Java-Clean-Code-4-liner/109226
 *  https://leetcode.com/problems/beautiful-arrangement-ii/discuss/106948/C%2B%2B-Java-Clean-Code-4-liner
 */
package com.an7one.leetcode.lvl3.lc0667

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0LinearScan {
    fun constructArray(n: Int, k: Int): IntArray {
        val ans = IntArray(n) { 0 }

        var lo = 1
        var hi = n
        var k = k

        for (idx in 0 until n) {
            ans[idx] = if (k % 2 == 0) {
                hi--
            } else {
                lo++
            }

            if (k > 1) {
                --k
            }
        }

        return ans
    }
}