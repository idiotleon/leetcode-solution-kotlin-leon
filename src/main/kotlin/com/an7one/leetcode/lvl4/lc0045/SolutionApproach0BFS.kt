package com.an7one.leetcode.lvl4.lc0045

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
/**
 * https://leetcode.com/problems/jump-game-ii/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/jump-game-ii/discuss/18014/Concise-O(n)-one-loop-JAVA-solution-based-on-Greedy/191474
 *  https://leetcode.com/problems/jump-game-ii/discuss/18014/Concise-O(n)-one-loop-JAVA-solution-based-on-Greedy
 */
@Suppress(UNUSED)
class SolutionApproach0BFS {
    fun jump(nums: IntArray): Int {
        val nNums = nums.size
        var jump = 0
        var curFurthest = 0
        var curEnd = 0

        for (idx in 0 until nNums - 1) {
            curFurthest = maxOf(curFurthest, idx + nums[idx])

            if (idx == curEnd) {
                ++jump
                curEnd = curFurthest

                // pruning here
                if (curEnd >= nNums - 1) return jump
            }
        }

        return if (curEnd >= nNums - 1) jump else -1
    }
}