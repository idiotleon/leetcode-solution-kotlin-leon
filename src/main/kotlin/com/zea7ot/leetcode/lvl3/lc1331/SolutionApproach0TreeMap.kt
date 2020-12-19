/**
 * https://leetcode.com/problems/rank-transform-of-an-array/
 *
 * Time Complexity:     O(`nNums` * lg(`nNums`))
 * Space Complexity:    O(`nNums`)
 *
 * References:
 *  https://leetcode.com/problems/rank-transform-of-an-array/discuss/489702/Java-TreeMap-sorting
 */
package com.zea7ot.leetcode.lvl3.lc1331

import java.util.*
import kotlin.collections.ArrayList
import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0TreeMap {
    fun arrayRankTransform(nums: IntArray): IntArray {
        val map = TreeMap<Int, ArrayList<Int>>()
        for (idx in nums.indices) {
            map.getOrPut(nums[idx]) { arrayListOf() }.add(idx)
        }

        var rank = 1
        for ((_, indexes) in map) {
            for (idx in indexes) nums[idx] = rank
            ++rank
        }

        return nums
    }
}