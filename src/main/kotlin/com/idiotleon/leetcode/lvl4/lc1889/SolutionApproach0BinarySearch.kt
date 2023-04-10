package com.idiotleon.leetcode.lvl4.lc1889

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/minimum-space-wasted-from-packaging/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * Reference:
 * https://leetcode.com/problems/minimum-space-wasted-from-packaging/discuss/1254123/Java-Binary-Search-%2B-Prefix-Sum
 */
@Suppress(UNUSED)
class SolutionApproach0BinarySearch {
    private companion object {
        private const val MOD = 1e9.toInt() + 7
    }

    fun minWastedSpace(packages: IntArray, boxes: Array<IntArray>): Int {
        val nPkgs = packages.size
        packages.sort()
        val prefixSums = LongArray(nPkgs + 1) { 0L }
        for (idx in packages.indices) {
            prefixSums[idx + 1] = prefixSums[idx] + packages[idx].toLong()
        }

        var minWasted = Long.MAX_VALUE
        for (box in boxes) {
            box.sort()
            if (packages.last() > box.last()) continue

            var curWasted = 0L
            var prevIdxPkg = 0

            for (cap in box) {
                if (cap < packages[0]) continue

                val idxPkg = upperBound(packages, cap)
                val pkgSpace = prefixSums[idxPkg + 1] - prefixSums[prevIdxPkg]
                val len = idxPkg - prevIdxPkg + 1
                val wasted = (len.toLong() * cap) - pkgSpace
                prevIdxPkg = idxPkg + 1
                curWasted += wasted
            }

            minWasted = minOf(minWasted, curWasted)
        }

        return if (minWasted == Long.MAX_VALUE) -1 else (minWasted % MOD).toInt()
    }

    private fun upperBound(nums: IntArray, target: Int): Int {
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