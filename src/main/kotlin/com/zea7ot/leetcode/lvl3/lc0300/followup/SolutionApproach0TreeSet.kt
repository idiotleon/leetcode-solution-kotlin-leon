/**
 * https://leetcode.com/problems/longest-increasing-subsequence/
 *
 * Time Complexity:     O(`totalNums` * lg(`totalNums`))
 * Space Complexity:    O(`totalNums`)
 */
package com.zea7ot.leetcode.lvl3.lc0300.followup

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0TreeSet {
    fun lengthOfLIS(nums: IntArray): Int {
        // not used
        // val totalNums = nums.size

        val treeSet = TreeSet<Int>()
        for (num in nums) {
            val ceil = treeSet.ceiling(num)
            ceil?.let { treeSet.remove(it) }
            treeSet.add(num)
        }

        return treeSet.size
    }
}