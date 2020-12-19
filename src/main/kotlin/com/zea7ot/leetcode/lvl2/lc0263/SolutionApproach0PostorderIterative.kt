/**
 * https://leetcode.com/problems/ugly-number/
 *
 * Time Complexity:     O(1)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/ugly-number/discuss/69214/2-4-lines-every-language/71180
 */
package com.zea7ot.leetcode.lvl2.lc0263

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0PostorderIterative {
    fun isUgly(num: Int): Boolean {
        if (num <= 0) return false

        var num = num
        while (num % 5 == 0) num /= 5
        while (num % 3 == 0) num /= 3
        while (num % 2 == 0) num /= 2

        return num == 1
    }
}