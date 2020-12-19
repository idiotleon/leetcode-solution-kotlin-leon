/**
 * @author: Leon
 * https://leetcode.com/problems/number-of-good-ways-to-split-a-string/
 *
 * Time Complexity:     O(`lenS`)
 * Space Complexity:    O(`lenS`)
 */
package com.zea7ot.leetcode.lvl2.lc1525

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0LinearScan1 {
    fun numSplits(s: String): Int {
        val lenS = s.length

        var freqs = IntArray(26) { 0 }

        val leftDistinct = IntArray(lenS) { 0 }
        var distinct = 0
        for (idx in s.indices) {
            if (freqs[s[idx] - 'a']++ == 0) ++distinct
            leftDistinct[idx] = distinct
        }

        freqs = IntArray(26) { 0 }
        distinct = 0
        val rightDistinct = IntArray(lenS) { 0 }
        for (idx in s.indices.reversed()) {
            if (freqs[s[idx] - 'a']++ == 0) ++distinct
            rightDistinct[idx] = distinct
        }

        var count = 0
        for (idx in leftDistinct.indices) {
            if (leftDistinct[idx] == rightDistinct[idx]) ++count
        }

        return count
    }
}