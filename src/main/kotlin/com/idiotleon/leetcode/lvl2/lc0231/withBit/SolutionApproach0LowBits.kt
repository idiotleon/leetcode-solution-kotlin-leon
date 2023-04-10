package com.idiotleon.leetcode.lvl2.lc0231.withBit

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/power-of-two/
 *
 * Time Complexity:     O(1)
 * Space Complexity:    O(1)
 */
@Suppress(UNUSED)
class SolutionApproach0LowBits {
    fun isPowerOfTwo(n: Int) = when {
        n <= 0 -> false
        else -> (n and (n - 1)) == 0
    }
}