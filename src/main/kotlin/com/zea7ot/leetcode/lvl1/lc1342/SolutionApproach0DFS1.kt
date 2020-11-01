/**
 * @author: Leon
 * https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/
 *
 * Time Complexity:     O(lg(`n`))
 * Space Complexity:    O(1)
 */
package com.zea7ot.leetcode.lvl1.lc1342

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DFS1 {
    fun numberOfSteps(n: Int): Int {
        var num = n
        var steps = 0

        while (num > 0) {
            if (num % 2 == 0) num /= 2
            else num -= 1

            ++steps
        }

        return steps
    }
}