package com.idiotleon.summary.byAlgorithm.search.binarySearch.integer

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 *
 * Time Complexity:     O(lg(`nNums`))
 * Space Complexity:    O(1)
 *
 * UpperBound:
 * to find the first or the smallest index,
 * in a sorted array,
 * where the value at that index is strictly greater than the target.
 *
 * The current implementation is slightly modified,
 * where it returns the last index,
 * while the condition is met.
 *
 * Reference:
 * https://github.com/phishman3579/java-algorithms-implementation/blob/master/src/com/jwetherell/algorithms/search/UpperBound.java
 *
 * Sample Problem:
 * https://leetcode.com/problems/maximum-count-of-positive-integer-and-negative-integer/
 */
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