/**
 * @author: Leon
 *
 * Time Complexity:     O(lg(`nNums`))
 * Space Complexity:    O(1)
 *
 * References:
 *  https://github.com/phishman3579/java-algorithms-implementation/blob/master/src/com/jwetherell/algorithms/search/UpperBound.java
 */
package com.an7one.summary.byAlgorithm.search.binarySearch.integer

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class UpperBound {
    fun upperBound(nums: IntArray, target: Int): Int {
        val nNums = nums.size

        var lo = 0
        var hi = nNums

        while (lo < hi) {
            val mid = lo + (hi - lo) / 2

            if (nums[mid] <= target) {
                lo = mid + 1
            } else {
                hi = mid
            }
        }

        return hi - 1
    }
}