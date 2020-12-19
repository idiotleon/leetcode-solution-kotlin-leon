/**
 * https://leetcode.com/problems/sum-of-mutated-array-closest-to-target/
 *
 * Time Complexity:     O(`totalNums` * lg(`sum`))
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/sum-of-mutated-array-closest-to-target/discuss/463222/Java-Binary-search-O(nlogk)-k-is-the-max-value-in-nums
 */
package com.zea7ot.leetcode.lvl3.lc1300

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED
import kotlin.math.abs

@Suppress(UNUSED)
class SolutionApproach0BinarySearch {
    fun findBestValue(nums: IntArray, target: Int): Int {
        // sanity check
        if (nums.isEmpty()) return 0

        // not used
        // val totalNums = nums.size

        var max = Int.MIN_VALUE
        var sum = 0
        for (num in nums) {
            max = maxOf(max, num)
            sum += num
        }

        if (sum <= target) return max

        var diff = target
        var prevValue = max

        var lo = 0
        var hi = max

        while (lo < hi) {
            val mid = lo + (hi - lo) / 2
            sum = getSum(nums, mid)

            val curDiff = abs(target - sum)
            if (curDiff < diff) {
                diff = curDiff
                prevValue = mid
            } else if (curDiff == diff) {
                prevValue = minOf(prevValue, mid)
            }

            if (sum < target) {
                lo = mid + 1
            } else {
                hi = mid
            }
        }

        return prevValue
    }

    private fun getSum(nums: IntArray, limit: Int): Int {
        var sum = 0
        for (num in nums) {
            sum += minOf(num, limit)
        }
        return sum
    }
}