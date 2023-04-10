/**
 * https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/
 *
 * Time Complexity:     O(lg(`n`))
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/discuss/502710/javaPython-3-3-Straight-forward-codes-w-picture-explanation-and-analysis.
 */
package com.idiotleon.leetcode.lvl1.lc1342

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DFS {
    fun numberOfSteps(n: Int): Int {
        var num = n
        var steps = 0

        while (num > 0) {
            steps += if (num % 2 == 0 || num == 1) 1 else 2
            num /= 2
        }

        return steps
    }
}