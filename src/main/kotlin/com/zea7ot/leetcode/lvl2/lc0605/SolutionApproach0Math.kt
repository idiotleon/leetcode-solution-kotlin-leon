/**
 * https://leetcode.com/problems/can-place-flowers/
 *
 * Time Complexity:     O(`nBeds`)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/can-place-flowers/discuss/103883/Java-Very-easy-solution/236171
 *  https://leetcode.com/problems/can-place-flowers/discuss/103883/Java-Very-easy-solution
 */
package com.zea7ot.leetcode.lvl2.lc0605

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Math {
    fun canPlaceFlowers(flowerbed: IntArray, n: Int): Boolean {
        // not used
        // val nBeds = flowerbed.size

        var count = 1
        var capacity = 0

        for (bed in flowerbed) {
            if (bed == 0) {
                ++count
            } else {
                capacity += (count - 1) / 2
                count = 0
            }
        }

        if (count != 0) capacity += count / 2
        return capacity >= n
    }
}