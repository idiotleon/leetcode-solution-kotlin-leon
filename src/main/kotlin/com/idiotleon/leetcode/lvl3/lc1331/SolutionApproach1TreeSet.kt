package com.idiotleon.leetcode.lvl3.lc1331

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

/**
 * @author: Leon
 * https://leetcode.com/problems/rank-transform-of-an-array/
 *
 * Time Complexity:     O(`nNums` * lg(`nNums`))
 * Space Complexity:    O(`nNums`)
 *
 * Reference:
 * https://leetcode.com/problems/rank-transform-of-an-array/discuss/490843/Simple-Java-Solution
 */
@Suppress(UNUSED)
class SolutionApproach1TreeSet {
    fun arrayRankTransform(nums: IntArray): IntArray {
        val nNums = nums.size

        val treeSet = TreeSet<Int>()
        for (num in nums) {
            treeSet.add(num)
        }

        val ranks = HashMap<Int, Int>()
        var rank = 1
        for (num in treeSet) {
            ranks[num] = rank++
        }

        val ans = IntArray(nNums) { 0 }
        for (idx in nums.indices) {
            ans[idx] = ranks[nums[idx]]!!
        }
        return ans
    }
}