/**
 * https://leetcode.com/problems/n-queens-ii/
 *
 * Time Complexity:     O(`n` * `n`!)
 * Space Complexity:    O(`n`)
 *
 * `board` is NOT needed at all
 *
 * References:
 *  https://leetcode.com/problems/n-queens-ii/discuss/20048/Easiest-Java-Solution-(1ms-98.22)
 *  https://leetcode.wang/leetCode-52-N-QueensII.html
 *  https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247484709&idx=1&sn=1c24a5c41a5a255000532e83f38f2ce4&chksm=9bd7fb2daca0723be888b30345e2c5e64649fc31a00b05c27a0843f349e2dd9363338d0dac61&scene=178&cur_album_id=1318883740306948097#rd
 */
package com.zea7ot.leetcode.lvl4.lc0052

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Backtrack1 {
    fun totalNQueens(n: Int): Int {

        val isSameColumn = BooleanArray(n) { false }
        val isSameMainDiagonal = BooleanArray(2 * n - 1) { false }
        val isSameAntidiagonal = BooleanArray(2 * n - 1) { false }

        val count = intArrayOf(0)
        backtrack(0, isSameColumn, isSameMainDiagonal, isSameAntidiagonal, n, count)

        return count[0]
    }

    private fun backtrack(
        row: Int,
        isSameColumn: BooleanArray,
        isSameMainDiagonal: BooleanArray,
        isSameAntidiagonal: BooleanArray,
        sideLen: Int,
        count: IntArray
    ) {
        if (row == sideLen) ++count[0]

        for (col in 0 until sideLen) {
            val mainDiagonal = col - row + sideLen - 1
            val antidiagonal = row + col

            if (isSameColumn[col] || isSameMainDiagonal[mainDiagonal] || isSameAntidiagonal[antidiagonal]) continue

            isSameColumn[col] = true
            isSameMainDiagonal[mainDiagonal] = true
            isSameAntidiagonal[antidiagonal] = true

            backtrack(row + 1, isSameColumn, isSameMainDiagonal, isSameAntidiagonal, sideLen, count)

            isSameColumn[col] = false
            isSameMainDiagonal[mainDiagonal] = false
            isSameAntidiagonal[antidiagonal] = false
        }
    }
}