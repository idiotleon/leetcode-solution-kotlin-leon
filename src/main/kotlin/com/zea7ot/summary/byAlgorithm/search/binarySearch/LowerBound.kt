/**
 * @author: Leon
 *
 * Time Complexity:     O(lg(`nNums`))
 * Space Complexity:    O(1)
 *
 * References:
 *  https://github.com/phishman3579/java-algorithms-implementation/blob/master/src/com/jwetherell/algorithms/search/LowerBound.java
 */
package com.zea7ot.summary.byAlgorithm.search.binarySearch

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class LowerBound {
    fun lowerBound(nums: IntArray, target: Int): Int {
        val nNums = nums.size

        var lo = 0
        var hi = nNums

        while (lo < hi) {
            val mid = lo + (hi - lo) / 2

            if (nums[mid] >= target) {
                hi = mid
            } else {
                lo = mid + 1
            }
        }

        return lo
    }
}