/**
 * https://leetcode.com/problems/complement-of-base-10-integer/
 *
 * Time Complexity:     O(lg(`N`))
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/complement-of-base-10-integer/discuss/258500/Java-0ms-32mb...-beats-100
 *  https://leetcode.com/problems/complement-of-base-10-integer/discuss/258500/Java-0ms-32mb...-beats-100/275793
 *  https://leetcode.com/problems/complement-of-base-10-integer/discuss/613118/4-approaches%3A-bitwise-operation-math-formular-one-naive-simulation-and-bonus
 */
package com.zea7ot.lc.lvl1.lc1009

import com.zea7ot.lc.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0BitManipulation {
    fun bitwiseComplement(N: Int): Int {
        var x = 1
        do {
            x = x shl 1
        } while (x <= N)

        return N xor (x - 1)
    }
}