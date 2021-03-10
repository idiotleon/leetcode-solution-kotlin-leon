/**
 * https://leetcode.com/problems/n-queens-ii/
 *
 * Time Complexity:     O(`n`!)
 * Space Complexity:    O(`n`)
 *
 * `board` is NOT needed at all
 *
 * References:
 *  https://leetcode.com/problems/n-queens-ii/discuss/20058/Accepted-Java-Solution/172490
 *  https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247484709&idx=1&sn=1c24a5c41a5a255000532e83f38f2ce4&chksm=9bd7fb2daca0723be888b30345e2c5e64649fc31a00b05c27a0843f349e2dd9363338d0dac61&scene=178&cur_album_id=1318883740306948097#rd
 */
package com.an7one.leetcode.lvl4.lc0052

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Backtrack {
    fun totalNQueens(n: Int): Int {

        val isSameColumn = BooleanArray(n) { false }
        val isSameMainDiagonal = BooleanArray(2 * n - 1) { false }
        val isSameAntidiagonal = BooleanArray(2 * n - 1) { false }

        return backtrack(0, isSameColumn, isSameMainDiagonal, isSameAntidiagonal, n)
    }

    private fun backtrack(
        row: Int,
        isSameColumn: BooleanArray,
        isSameMainDiagonal: BooleanArray,
        isSameAntidiagonal: BooleanArray,
        sideLen: Int
    ): Int {
        if (row == sideLen)
            return 1

        var count = 0

        for (col in 0 until sideLen) {
            if (isSameColumn[col] || isSameMainDiagonal[row + sideLen - col - 1] || isSameAntidiagonal[row + col]) continue

            // to further backtrack to the next state
            isSameColumn[col] = true
            isSameMainDiagonal[row + sideLen - col - 1] = true
            isSameAntidiagonal[row + col] = true

            count += backtrack(1 + row, isSameColumn, isSameMainDiagonal, isSameAntidiagonal, sideLen)

            // to backtrack to the previous state
            isSameColumn[col] = false
            isSameMainDiagonal[row + sideLen - col - 1] = false
            isSameAntidiagonal[row + col] = false
        }

        return count
    }
}