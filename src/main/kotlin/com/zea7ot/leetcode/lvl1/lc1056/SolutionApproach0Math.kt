/**
 * https://leetcode.com/problems/confusing-number/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/confusing-number/discuss/303832/Java-Solution-using-HashMap-Similar-to-246.-Strobogrammatic-Number/447381
 *  https://leetcode.com/problems/confusing-number/discuss/303832/Java-Solution-using-HashMap-Similar-to-246.-Strobogrammatic-Number
 */
package com.zea7ot.leetcode.lvl1.lc1056

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Math {
    private companion object {
        private val map = intArrayOf(0, 1, -1, -1, -1, -1, 9, -1, 8, 6)
    }

    fun confusingNumber(num: Int): Boolean {
        var src = num
        var reversed = 0

        while (src > 0) {
            val digit = src % 10
            src /= 10

            if (map[digit] != -1) {
                reversed *= 10
                reversed += map[digit]
            } else return false
        }

        return reversed != num
    }
}