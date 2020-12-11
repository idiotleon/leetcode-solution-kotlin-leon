/**
 * https://leetcode.com/problems/nim-game/
 *
 * Time Complexity:     O(1)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/nim-game/discuss/73749/Theorem%3A-all-4s-shall-be-false
 */
package com.zea7ot.leetcode.lvl2.lc0292

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Math {
    fun canWinNim(n: Int): Boolean {
        return n % 4 != 0
    }
}