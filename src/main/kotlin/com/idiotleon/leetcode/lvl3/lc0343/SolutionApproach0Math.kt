package com.idiotleon.leetcode.lvl3.lc0343

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/integer-break/
 *
 * Time Complexity:     O(lg(`n`))
 * Space Complexity:    O(1)
 *
 * Reference:
 * https://leetcode.com/problems/integer-break/discuss/80689/A-simple-explanation-of-the-math-part-and-a-O(n)-solution
 */
@Suppress(UNUSED)
class SolutionApproach0Math {
    fun integerBreak(n: Int): Int {
        return when (n) {
            2 -> 1
            3 -> 2
            else -> {
                var product = 1
                var factor = n
                while (factor > 4) {
                    product *= 3
                    factor -= 3
                }

                product *= factor

                product
            }
        }
    }
}