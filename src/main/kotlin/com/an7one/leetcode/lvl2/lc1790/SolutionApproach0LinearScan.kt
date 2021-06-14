/**
 * https://leetcode.com/problems/check-if-one-string-swap-can-make-strings-equal/
 *
 * Time Complexity:     O(lenS)
 * Space Complexity:    O(1)
 *
 * Reference:
 *  https://leetcode.com/problems/check-if-one-string-swap-can-make-strings-equal/discuss/1111937/JavaScript-Easy-to-understand-2-solutions
 */
package com.an7one.leetcode.lvl2.lc1790

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0LinearScan {
    fun areAlmostEqual(s1: String, s2: String): Boolean {
        var cntDiff = 0
        var idxDiff1 = 0
        var idxDiff2 = 0

        for (idx in s1.indices) {
            if (s1[idx] == s2[idx])
                continue

            if (++cntDiff > 2)
                return false

            if (cntDiff == 1)
                idxDiff1 = idx
            else
                idxDiff2 = idx
        }

        return (cntDiff == 0 || cntDiff == 2) && s1[idxDiff1] == s2[idxDiff2] && s1[idxDiff2] == s2[idxDiff1]
    }
}