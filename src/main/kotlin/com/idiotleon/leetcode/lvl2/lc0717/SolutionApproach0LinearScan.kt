package com.idiotleon.leetcode.lvl2.lc0717

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/1-bit-and-2-bit-characters/
 *
 * Time Complexity:     O(`nBits`)
 * Space Complexity:    O(`)
 *
 * Reference:
 * https://leetcode.com/problems/1-bit-and-2-bit-characters/discuss/108967/JAVA-check-only-the-end-of-array
 */
@Suppress(UNUSED)
class SolutionApproach0LinearScan {
    fun isOneBitCharacter(bits: IntArray): Boolean {
        val nBits = bits.size

        var cntOne = 0
        for (idx in nBits - 2 downTo 0) {
            if (bits[idx] == 0) break
            ++cntOne
        }

        if (cntOne % 2 > 0) return false
        return true
    }
}