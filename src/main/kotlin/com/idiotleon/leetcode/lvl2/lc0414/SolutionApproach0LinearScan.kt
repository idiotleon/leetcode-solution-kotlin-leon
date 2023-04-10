package com.idiotleon.leetcode.lvl2.lc0414

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/third-maximum-number/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/third-maximum-number/discuss/90202/Java-neat-and-easy-understand-solution-O(n)-time-O(1)-space
 */
@Suppress(UNUSED)
class SolutionApproach0LinearScan {
    fun thirdMax(nums: IntArray): Int {
        var max: Int? = null
        var maxSec: Int? = null
        var maxThd: Int? = null

        loop@ for (num in nums) {
            when {
                num == max || num == maxSec || num == maxThd -> continue@loop
                max == null || num > max -> {
                    maxThd = maxSec
                    maxSec = max
                    max = num
                }

                maxSec == null || num > maxSec -> {
                    maxThd = maxSec
                    maxSec = num
                }

                maxThd == null || num > maxThd -> maxThd = num

                else -> {

                }
            }
        }

        return if (maxThd == null) max!! else maxThd
    }
}