package com.an7one.summary.byAlgorithm.search.binarySearch.integer

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

/**
 * YXC: 大雪菜闫学灿
 *
 * Reference:
 * Paid Membership Required: https://www.acwing.com/video/10/
 */
@Suppress(UNUSED)
class BinarySearchXYC {
    // to partition [low, high] into [lo, mid] and [mid + 1, high]
    fun binarySearch1(low: Int, high: Int, target: Int, nums: IntArray): Int {
        var lo = low
        var hi = high

        while (lo < hi) {
            val mid = lo + hi shr 1
            if (check(mid, target, nums)) hi = mid
            else lo = mid + 1
        }

        return lo
    }

    // to partition [low, high] into [lo, mid - 1] and [mid, high]
    fun binarySearch2(low: Int, high: Int, target: Int, nums: IntArray): Int {
        var lo = low
        var hi = high

        while (lo < hi) {
            val mid = lo + hi + 1 shr 1
            if (check(mid, target, nums)) lo = mid
            else hi = mid - 1
        }

        return lo
    }

    fun check(mid: Int, target: Int, nums: IntArray) = nums[mid] == target
}