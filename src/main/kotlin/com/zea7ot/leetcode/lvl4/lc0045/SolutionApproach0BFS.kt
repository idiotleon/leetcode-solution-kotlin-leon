/**
 * https://leetcode.com/problems/jump-game-ii/
 *
 * Time Complexity:     O(`totalNums`)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/jump-game-ii/discuss/18014/Concise-O(n)-one-loop-JAVA-solution-based-on-Greedy/191474
 *  https://leetcode.com/problems/jump-game-ii/discuss/18014/Concise-O(n)-one-loop-JAVA-solution-based-on-Greedy
 */
package com.zea7ot.leetcode.lvl4.lc0045

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0BFS {
    fun jump(nums: IntArray): Int {
        val totalNums = nums.size
        var jump = 0
        var curFurthest = 0
        var curEnd = 0

        for (idx in 0 until totalNums - 1) {
            curFurthest = maxOf(curFurthest, idx + nums[idx])

            if (idx == curEnd) {
                ++jump
                curEnd = curFurthest

                // pruning here
                if (curEnd >= totalNums - 1) return jump
            }
        }

        return if (curEnd >= totalNums - 1) jump else -1
    }
}