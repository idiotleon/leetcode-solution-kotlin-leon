/**
 * https://leetcode.com/problems/number-of-good-ways-to-split-a-string/
 *
 * Time Complexity:     O(`lenS`)
 * Space Complexity:    O(26) ~ O(1)
 *
 * References:
 *  https://leetcode.com/problems/number-of-good-ways-to-split-a-string/discuss/754941/Java-simple-O(n)
 */
package com.idiotleon.leetcode.lvl2.lc1525

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0LinearScan {
    fun numSplits(s: String): Int {
        // not used
        // val lenS = s.length

        val rightFreqs = IntArray(26) { 0 }
        var rightDistinct = 0
        for (ch in s) {
            if (rightFreqs[ch - 'a']++ == 0) ++rightDistinct
        }

        var count = 0

        val leftFreqs = IntArray(26) { 0 }
        var leftDistinct = 0
        for (ch in s) {
            if (leftFreqs[ch - 'a']++ == 0) ++leftDistinct
            if (--rightFreqs[ch - 'a'] == 0) --rightDistinct
            if (leftDistinct == rightDistinct) ++count

            // pruning here
            if (leftDistinct > rightDistinct) break
        }

        return count
    }
}