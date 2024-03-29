package com.idiotleon.leetcode.lvl3.lc0397

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/integer-replacement/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * Reference:
 * https://leetcode.com/problems/integer-replacement/discuss/87928/Java-12-line-4(5)ms-iterative-solution-with-explanations.-No-other-data-structures.
 */
@Suppress(UNUSED)
class SolutionApproach0DFS1 {
    fun integerReplacement(n: Int): Int {
        if (n == Int.MAX_VALUE) return 32

        var count = 0
        var num = n
        while (num > 1) {
            when {
                num % 2 == 0 -> num /= 2
                (n + 1) % 4 == 0 && (n - 1 != 2) -> ++num
                else -> --num
            }

            ++count
        }

        return count
    }
}