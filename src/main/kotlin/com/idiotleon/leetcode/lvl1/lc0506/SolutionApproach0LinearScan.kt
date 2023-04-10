/**
 * https://leetcode.com/problems/relative-ranks/
 *
 * Time Complexity:     O(`nNums` * lg(`nNums`)) + O(`nNums`) ~ O(`nNums` * lg(`nNums`))
 * Space Complexity:    O(`nNums`)
 *
 * References:
 *  https://leetcode.com/problems/relative-ranks/discuss/98468/Easy-Java-Solution-Sorting./102806
 *  https://leetcode.com/problems/relative-ranks/discuss/98468/Easy-Java-Solution-Sorting.
 */
package com.idiotleon.leetcode.lvl1.lc0506

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0LinearScan {
    private companion object {
        private const val MEDAL_GOLD = "Gold Medal"
        private const val MEDAL_SILVER = "Silver Medal"
        private const val MEDAL_BRONZE = "Bronze Medal"
    }

    fun findRelativeRanks(nums: IntArray): Array<String> {
        val nNums = nums.size
        val sorted = nums.sorted()

        val ranks = HashMap<Int, Int>()
        for ((idx, num) in sorted.withIndex()) {
            ranks[num] = nNums - idx
        }

        val ans = Array(nNums) { "" }
        for ((idx, num) in nums.withIndex()) {
            val rankStr = when (val rank = ranks[num]!!) {
                1 -> MEDAL_GOLD
                2 -> MEDAL_SILVER
                3 -> MEDAL_BRONZE
                else -> rank.toString()
            }

            ans[idx] = rankStr
        }

        return ans
    }
}