/**
 * YXC: 大雪菜闫学灿
 *
 * References:
 *  Paid Membership Required: https://www.acwing.com/video/10/
 */
package com.zea7ot.summary.byAlgorithm.search.binarySearch.double

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class BinarySearchXYC {
    private companion object {
        private const val TOLERANCE = 1e-7
    }

    fun sqrt(num: Double): Double {
        var lo = 0.0
        var hi = num

        while (hi - lo > TOLERANCE) {
            val mid = lo + (hi - lo) / 2
            if (mid * mid >= num) hi = mid
            else lo = mid
        }

        return lo
    }
}