/**
 * https://leetcode.com/problems/count-of-smaller-numbers-after-self/
 *
 * Time Complexity:     O(`totalNums` * lg(`totalNums`)) + O(`totalNums`) ~ O(`totalNums` * lg(`totalNums`))
 * Space Complexity:    O(`totalNums`) + O(`max`)
 *
 * References:
 *  https://leetcode.com/problems/count-of-smaller-numbers-after-self/discuss/76674/3-Ways-(Segment-Tree-Binary-Indexed-Tree-Merge-Sort)-clean-Java-code
 */
package com.zea7ot.leetcode.lvl5.lc0315

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0BinaryIndexedTree {
    fun countSmaller(nums: IntArray): List<Int> {
        val ans = ArrayList<Int>()
        // sanity check, required
        if (nums.isEmpty()) return ans

        val min = nums.min() ?: nums[0]
        for (idx in nums.indices) {
            nums[idx] -= (min - 1)
        }

        val max = nums.max() ?: nums[0]
        val bit = IntArray(max + 1) { 0 }

        for (idx in nums.indices.reversed()) {
            ans.add(get(nums[idx] - 1, bit))
            update(nums[idx], bit)
        }

        ans.reverse()
        return ans
    }

    private fun update(index: Int, bit: IntArray) {
        val totalBits = bit.size
        var idx = index

        while (idx < totalBits) {
            ++bit[idx]
            idx += (idx and -idx)
        }
    }

    private fun get(index: Int, bit: IntArray): Int {
        var sum = 0
        var idx = index
        while (idx > 0) {
            sum += bit[idx]
            idx -= (idx and -idx)
        }

        return sum
    }
}