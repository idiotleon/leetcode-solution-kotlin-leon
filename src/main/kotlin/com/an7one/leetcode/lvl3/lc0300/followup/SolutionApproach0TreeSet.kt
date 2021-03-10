/**
 * https://leetcode.com/problems/longest-increasing-subsequence/
 *
 * Time Complexity:     O(`nNums` * lg(`nNums`))
 * Space Complexity:    O(`nNums`)
 */
package com.an7one.leetcode.lvl3.lc0300.followup

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0TreeSet {
    fun lengthOfLIS(nums: IntArray): Int {
        // not used
        // val nNums = nums.size

        val treeSet = TreeSet<Int>()
        for (num in nums) {
            val ceil = treeSet.ceiling(num)
            ceil?.let { treeSet.remove(it) }
            treeSet.add(num)
        }

        return treeSet.size
    }
}