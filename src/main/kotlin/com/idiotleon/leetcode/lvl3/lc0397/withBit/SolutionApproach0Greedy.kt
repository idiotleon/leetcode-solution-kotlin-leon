package com.idiotleon.leetcode.lvl3.lc0397.withBit

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/integer-replacement/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * Reference:
 * https://leetcode.com/problems/integer-replacement/discuss/87920/A-couple-of-Java-solutions-with-explanations
 */
@Suppress(UNUSED)
class SolutionApproach0Greedy {
    fun integerReplacement(n: Int): Int {
        var count = 0
        var num = n
        while (num != 1) {
            when {
                (num and 1) == 0 -> num = num ushr 1
                num == 3 || ((num ushr 1) and 1) == 0 -> --num
                else -> ++num
            }

            ++count
        }

        return count
    }
}