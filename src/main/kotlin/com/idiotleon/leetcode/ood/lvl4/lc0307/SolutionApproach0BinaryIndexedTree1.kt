package com.idiotleon.leetcode.ood.lvl4.lc0307

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/range-sum-query-mutable/
 *
 * Time Complexities:
 *  initialization:     O(`nNums` * lg(`nNums`))
 *  `update()`:         O(lg(`nNums`))
 *  `sumRange()`:       O(lg(`nNums`))
 *
 * Space Complexity:    O(`nNums`)
 *
 * Reference:
 * https://leetcode.com/problems/range-sum-query-mutable/discuss/75753/Java-using-Binary-Indexed-Tree-with-clear-explanation
 * https://cs.stackexchange.com/questions/10538/bit-what-is-the-intuition-behind-a-binary-indexed-tree-and-how-was-it-thought-a
 */
@Suppress(UNUSED)
class SolutionApproach0BinaryIndexedTree1(private val nums: IntArray) {
    private val nNums = nums.size
    private val bit = BIT(nNums)

    init {
        for (idx in nums.indices) {
            bit.update(idx, nums[idx])
        }
    }

    fun update(i: Int, value: Int) {
        val diff = value - nums[i]
        nums[i] = value
        bit.update(i, diff)
    }

    fun sumRange(i: Int, j: Int): Int {
        return bit.getSum(j) - bit.getSum(i - 1)
    }

    private class BIT(private val nNums: Int) {
        private val fenwick = IntArray(nNums + 1) { 0 }

        fun getSum(index: Int): Int {
            var sum = 0
            var idx = index + 1

            while (idx > 0) {
                sum += fenwick[idx]
                idx -= (idx and -idx)
            }

            return sum
        }

        fun update(index: Int, value: Int) {
            var idx = index + 1
            while (idx <= nNums) {
                fenwick[idx] += value
                idx += (idx and -idx)
            }
        }
    }
}