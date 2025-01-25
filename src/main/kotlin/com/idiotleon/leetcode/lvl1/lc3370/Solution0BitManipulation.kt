package com.idiotleon.leetcode.lvl1.lc3370

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/smallest-number-with-all-set-bits/
 *
 * Time Complexity:     O(lg(`n`))
 * Space Complexity:    O(1)
 *
 * Reference:
 * https://leetcode.com/problems/smallest-number-with-all-set-bits/solutions/6098860/java-c-python-different-ideas/
 */
@Suppress(UNUSED)
class Solution0BitManipulation {
    fun smallestNumber(n: Int): Int {
        var ans = 1
        while (ans < n) {
            ans = ans * 2 + 1
        }

        return ans
    }
}