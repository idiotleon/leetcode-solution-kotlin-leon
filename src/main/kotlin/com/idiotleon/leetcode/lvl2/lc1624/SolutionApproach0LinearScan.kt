/**
 * @author: Leon
 * https://leetcode.com/problems/largest-substring-between-two-equal-characters/
 *
 * Time Complexity:     O(`lenS`)
 * Space Complexity:    O(26) ~ O(1)
 */
package com.idiotleon.leetcode.lvl2.lc1624

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0LinearScan {
    fun maxLengthBetweenEqualCharacters(s: String): Int {
        val lenS = s.length
        val firstIndexesOf = IntArray(26) { -1 }

        var longest = -1
        for (idx in 0 until lenS) {
            val idxCh = (s[idx] - 'a')
            if (firstIndexesOf[idxCh] < 0) {
                firstIndexesOf[idxCh] = idx
            } else {
                val len = idx - firstIndexesOf[idxCh] + 1 - 2
                longest = maxOf(longest, len)
            }
        }

        return longest
    }
}