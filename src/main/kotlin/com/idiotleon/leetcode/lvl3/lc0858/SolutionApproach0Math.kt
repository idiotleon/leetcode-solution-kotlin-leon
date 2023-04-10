package com.idiotleon.leetcode.lvl3.lc0858

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/mirror-reflection/
 *
 * Time Complexity:     O(1)
 * Space Complexity:    O(1)
 *
 * Reference:
 * https://leetcode.com/problems/mirror-reflection/discuss/146336/Java-solution-with-an-easy-to-understand-explanation
 */
@Suppress(UNUSED)
class SolutionApproach0Math {
    fun mirrorReflection(p: Int, q: Int): Int {
        var m = 1
        var n = 1
        while (m * p != n * q) {
            ++n
            m = n * q / p
        }

        if (m % 2 == 0 && n % 2 == 1) return 0
        if (m % 2 == 1 && n % 2 == 1) return 1
        if (m % 2 == 1 && n % 2 == 0) return 2

        return -1
    }
}