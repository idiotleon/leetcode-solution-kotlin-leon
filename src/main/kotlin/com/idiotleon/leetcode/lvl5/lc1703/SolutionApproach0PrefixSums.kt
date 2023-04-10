package com.idiotleon.leetcode.lvl5.lc1703

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/minimum-adjacent-swaps-for-k-consecutive-ones/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * Reference:
 * https://leetcode.com/problems/minimum-adjacent-swaps-for-k-consecutive-ones/discuss/987607/O(n)-explanation-with-picture/803569s
 * https://leetcode.com/problems/minimum-adjacent-swaps-for-k-consecutive-ones/discuss/987607/O(n)-explanation-with-picture
 * https://leetcode.com/problems/minimum-adjacent-swaps-for-k-consecutive-ones/discuss/987362/Python-The-trick-and-related-problems
 */
@Suppress(UNUSED)
class SolutionApproach0PrefixSums {
    fun minMoves(nums: IntArray, k: Int): Int {
        if (k == 1) return 0

        val onesIndices = mutableListOf<Int>()
        for (idx in nums.indices) {
            if (nums[idx] == 1) {
                onesIndices.add(idx)
            }
        }

        val nOnes = onesIndices.size

        val prefixSums = onesIndices.toTypedArray()
        for (idx in 1 until nOnes) {
            prefixSums[idx] += prefixSums[idx - 1]
        }

        var minSwaps = Int.MAX_VALUE

        for (mid in (k - 1) / 2 until nOnes - k / 2) {
            val radius = (k - 1) / 2

            val right = if (k % 2 == 0) {
                prefixSums[mid + radius + 1] - prefixSums[mid] - onesIndices[mid] // even case
            } else {
                prefixSums[mid + radius] - prefixSums[mid] // odd case
            }

            val left = if (mid == 0) {
                0
            } else {
                prefixSums[mid - 1] - if (mid - radius == 0) 0 else prefixSums[mid - radius - 1]
            }

            val save = (1 + radius) * radius + if (k % 2 == 0) 1 + radius else 0
            minSwaps = minOf(minSwaps, right - left - save)
        }

        return minSwaps
    }
}