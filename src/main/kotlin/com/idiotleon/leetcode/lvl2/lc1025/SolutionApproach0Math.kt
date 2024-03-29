/**
 * https://leetcode.com/problems/divisor-game/
 *
 * Time Complexity:     O(1)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/divisor-game/discuss/274606/JavaC%2B%2BPython-return-N-2-0
 */
package com.idiotleon.leetcode.lvl2.lc1025

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Math {
    fun divisorGame(N: Int): Boolean {
        return N % 2 == 0
    }
}