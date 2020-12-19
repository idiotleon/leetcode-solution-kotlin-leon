/**
 * https://leetcode.com/problems/predict-the-winner/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/predict-the-winner/discuss/96838/Java-'1-Line'-Recursive-Solution-O(n2)-Time-and-O(n)-Space/593512
 *  https://leetcode.com/problems/predict-the-winner/discuss/96838/Java-'1-Line'-Recursive-Solution-O(n2)-Time-and-O(n)-Space/203125
 */
package com.zea7ot.leetcode.lvl4.lc0486

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DFSMemo2 {
    fun predictTheWinner(nums: IntArray): Boolean {
        val totalNums = nums.size
        return canWin(true, 0, totalNums - 1, 0, 0, nums)
    }

    private fun canWin(
        isPlayer1: Boolean,
        start: Int, end: Int,
        score1: Int, score2: Int,
        nums: IntArray
    ): Boolean {
        if (start > end) return score1 >= score2

        return if (isPlayer1) {
            canWin(false, start + 1, end, score1 + nums[start], score2, nums) || canWin(
                false,
                start,
                end - 1,
                score1 + nums[end],
                score2,
                nums
            )
        } else {
            canWin(true, start + 1, end, score1, score2 + nums[start], nums) && canWin(
                true,
                start,
                end - 1,
                score1,
                score2 + nums[end],
                nums
            )
        }
    }
}