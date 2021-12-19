/**
 * https://leetcode.com/problems/minimum-size-subarray-sum/
 *
 * If you have figured out the O(n) solution,
 *  how about another solution of which the time complexity is O(n log n).
 *
 * Time Complexity:     O(N * lg(N)) + O(N) ~ O(N * lg(N))
 * Space Complexity:    O(N)
 *
 * prefix sums + binary search
 *
 * References:
 *  https://leetcode.com/problems/minimum-size-subarray-sum/discuss/59103/Two-AC-solutions-in-Java-with-time-complexity-of-N-and-NLogN-with-explanation
 */
package com.an7one.leetcode.lvl2.lc0209.followups.followup0

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0BinarySearch {
    fun minSubArrayLen(s: Int, nums: IntArray): Int {
        val nNums = nums.size

        val prefixSums = IntArray(nNums + 1) { 0 }.also {
            for (idx in 1..nNums) {
                it[idx] = it[idx - 1] + nums[idx - 1]
            }
        }

        if (prefixSums[nNums] < s)
            return 0

        var shortest = nNums + 1

        for (idxStart in prefixSums.indices) {
            val endIdx = lowerBound(idxStart + 1, nNums + 1, prefixSums, s + prefixSums[idxStart])

            if (endIdx == nNums + 1)
                break

            if (endIdx - idxStart < shortest)
                shortest = endIdx - idxStart
        }

        return shortest % (nNums + 1)
    }

    private fun lowerBound(low: Int, high: Int, prefixSums: IntArray, s: Int): Int {
        var lo = low
        var hi = high

        while (lo < hi) {
            val mid = lo + (hi - lo) / 2
            if (prefixSums[mid] >= s)
                hi = mid
            else
                lo = mid + 1
        }

        return lo
    }
}