/**
 * https://leetcode.com/problems/complement-of-base-10-integer/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/complement-of-base-10-integer/discuss/613118/4-approaches%3A-bitwise-operation-math-formular-one-naive-simulation-and-bonus
 */
package com.zea7ot.leetcode.lvl1.lc1009

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0BitManipulation2 {
    fun bitwiseComplement(num: Int): Int {
        if (num == 0) return 1
        var mask = num
        mask = mask or (mask shr 1)
        mask = mask or (mask shr 2)
        mask = mask or (mask shr 4)
        mask = mask or (mask shr 8)
        mask = mask or (mask shr 16)
        return num xor mask
    }
}