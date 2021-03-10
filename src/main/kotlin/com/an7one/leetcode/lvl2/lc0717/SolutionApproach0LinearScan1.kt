/**
 * https://leetcode.com/problems/1-bit-and-2-bit-characters/
 *
 * Time Complexity:     O(`nBits`)
 * Space Complexity:    O(`)
 *
 * References:
 *  https://leetcode.com/problems/1-bit-and-2-bit-characters/discuss/108969/Java-solution-1-or-2
 */
package com.an7one.leetcode.lvl2.lc0717

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0LinearScan1 {
    fun isOneBitCharacter(bits: IntArray): Boolean {
        val nBits = bits.size

        var idx = 0
        while (idx < nBits - 1) {
            if (bits[idx] == 0) ++idx
            else idx += 2
        }

        return idx == nBits - 1
    }
}