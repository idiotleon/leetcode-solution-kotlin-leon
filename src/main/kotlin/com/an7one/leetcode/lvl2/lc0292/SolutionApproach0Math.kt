package com.an7one.leetcode.lvl2.lc0292

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/nim-game/
 *
 * Time Complexity:     O(1)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/nim-game/discuss/73749/Theorem%3A-all-4s-shall-be-false
 */
@Suppress(UNUSED)
class SolutionApproach0Math {
    fun canWinNim(n: Int): Boolean {
        return n % 4 != 0
    }
}