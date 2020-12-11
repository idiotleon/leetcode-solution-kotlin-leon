/**
 * @author: Leon
 * https://leetcode.com/problems/power-of-two/
 *
 * Time Complexity:     O(1)
 * Space Complexity:    O(1)
 */
package com.zea7ot.leetcode.lvl2.lc0231.withBit

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0LowBits {
    fun isPowerOfTwo(n: Int) = when {
        n <= 0 -> false
        else -> (n and (n - 1)) == 0
    }
}