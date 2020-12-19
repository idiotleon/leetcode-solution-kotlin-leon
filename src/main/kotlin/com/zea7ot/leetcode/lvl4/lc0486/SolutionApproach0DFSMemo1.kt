/**
 * https://leetcode.com/problems/predict-the-winner/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/predict-the-winner/discuss/96838/Java-'1-Line'-Recursive-Solution-O(n2)-Time-and-O(n)-Space/203125
 */
package com.zea7ot.leetcode.lvl4.lc0486

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DFSMemo1 {
    private companion object {
        private const val PLAYER1 = 1
        private const val PLAYER2 = 2
    }

    fun predictTheWinner(nums: IntArray): Boolean {
        val totalNums = nums.size
        return canWin(PLAYER1, 0, totalNums - 1, 0, 0, nums)
    }

    private fun canWin(player: Int, start: Int, end: Int, score1: Int, score2: Int, nums: IntArray): Boolean {
        return when {
            start > end -> score1 >= score2
            start == end -> {
                if (player == PLAYER1) score1 + nums[start] >= score2
                else score1 < nums[start] + score2
            }
            else -> {
                if (player == PLAYER1) {
                    !canWin(PLAYER2, start + 1, end, score1 + nums[start], score2, nums) || !canWin(
                        PLAYER2,
                        start,
                        end - 1,
                        score1 + nums[end],
                        score2,
                        nums
                    )
                } else {
                    !canWin(PLAYER1, start + 1, end, score1, score2 + nums[start], nums) || !canWin(
                        PLAYER1,
                        start,
                        end - 1,
                        score1,
                        score2 + nums[end],
                        nums
                    )
                }
            }
        }
    }
}