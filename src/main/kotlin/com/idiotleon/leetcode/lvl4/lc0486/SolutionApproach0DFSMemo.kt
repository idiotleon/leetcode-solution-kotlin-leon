package com.idiotleon.leetcode.lvl4.lc0486

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/predict-the-winner/
 *
 * Time Complexity:     O(`nNums` ^ 2)
 * Space Complexity:    O(`nNums` ^ 2) + O(`nNums`) ~ O(`nNums` ^ 2)
 *
 * this approach simulates how player1 wins, assuming both players always take their optimized options
 *  1. the identity always is player1
 *  2. when player2 wins scores, to subtract the score from player1's total scores
 *  3. ultimately to see if player1 has any score left, which means player1 achieves more scores than player2, and thus wins
 *
 * Reference:
 * https://leetcode.com/problems/predict-the-winner/discuss/96838/Java-'1-Line'-Recursive-Solution-O(n2)-Time-and-O(n)-Space/171753
 * https://youtu.be/Tw1k46ywN6E?t=3622
 */
@Suppress(UNUSED)
class SolutionApproach0DFSMemo {
    fun predictTheWinner(nums: IntArray): Boolean {
        val nNums = nums.size
        val memo = Array(nNums) { Array<Int?>(nNums) { null } }
        return dfs(0, nNums - 1, nums, memo) >= 0
    }

    /**
     * to return the scores difference won by the player1
     *  which player is controlled by the levels of the call stack, which is subtle
     */
    private fun dfs(start: Int, end: Int, nums: IntArray, memo: Array<Array<Int?>>): Int {
        if (start == end) return nums[start]

        memo[start][end]?.let { return it }

        // to win the start/left score for player1,
        // and then to subtract the score by player2 in the next round
        val pickStart = nums[start] - dfs(start + 1, end, nums, memo)

        // to win the end/right score for player1,
        // and then to subtract the score by player2 in the next round
        val pickEnd = nums[end] - dfs(start, end - 1, nums, memo)

        // to pick whichever score is larger, won by player1
        val maxScore = maxOf(pickStart, pickEnd)
        memo[start][end] = maxScore
        return maxScore
    }
}