/**
 * https://leetcode.com/problems/reverse-pairs/
 *
 * Time Complexity:     O(`nNums` * lg(`nNums`)
 * Space Complexity:    O(`nNums`) / O(1)
 *
 * Reference:
 *  https://leetcode.com/problems/reverse-pairs/discuss/97268/General-principles-behind-problems-similar-to-"Reverse-Pairs"/189287
 *
 */
package com.idiotleon.leetcode.lvl5.lc0493

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0BinaryIndexedTree {
    fun reversePairs(nums: IntArray): Int {
        val nNums = nums.size

        val fenwick = IntArray(1 + nNums) { 0 }
        val sorted = nums.sorted()

        var count = 0

        for (idx in nums.indices.reversed()) {
            val num = nums[idx].toDouble()
            count += query(lowerBound(num / 2, sorted) - 1, fenwick)
            update(lowerBound(num, sorted), fenwick)
        }

        return count
    }

    private fun query(index: Int, fenwick: IntArray): Int {
        var sum = 0
        var idx = 1 + index

        while (idx > 0) {
            sum += fenwick[idx]
            idx -= idx and -idx
        }

        return sum
    }

    private fun update(index: Int, fenwick: IntArray) {
        val nBits = fenwick.size
        var idx = 1 + index

        while (idx < nBits) {
            ++fenwick[idx]
            idx += idx and -idx
        }
    }

    private fun lowerBound(target: Double, nums: List<Int>): Int {
        val nNums = nums.size

        var lo = 0
        var hi = nNums

        while (lo < hi) {
            val mid = lo + (hi - lo) / 2

            if (nums[mid].toDouble() >= target) {
                hi = mid
            } else {
                lo = mid + 1
            }
        }

        return lo
    }
}