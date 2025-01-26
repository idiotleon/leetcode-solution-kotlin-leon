package com.idiotleon.leetcode.lvl2.lc3360

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/stone-removal-game/
 *
 * Time Complexity:     O(`n`)
 * Space Complexity:    O(1)
 *
 * Reference:
 * https://leetcode.com/problems/stone-removal-game/solutions/6075696/commedy-with-code-o-1-o-1/
 */
@Suppress(UNUSED)
class Solution0LinearScan {
    fun canAliceWin(n: Int): Boolean {
        var n = n
        var win = false

        for (num in 10 downTo 0) {
            if (n - num < 0) {
                return win
            }
            n -= num
            win = !win
        }

        return win
    }
}