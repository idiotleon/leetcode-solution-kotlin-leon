package com.idiotleon.leetcode.lvl3.lc0838

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/push-dominoes/
 *
 * Time Complexity:     O(`lenD`)
 * Space Complexity:    O(`lenD`)
 *
 * Reference:
 * https://leetcode.com/problems/push-dominoes/discuss/132482/Java-one-pass-in-place-13ms
 */
@Suppress(UNUSED)
class SolutionApproach0LinearScan {
    private companion object {
        private const val PUSH_LEFT = 'L'
        private const val PUSH_RIGHT = 'R'

        // not used
        // private const val STANDING = '.'
    }

    fun pushDominoes(dominoes: String): String {
        val chs = dominoes.toCharArray()
        val lenD = dominoes.length

        var lastIdxL = -1
        var lastIdxR = -1

        for (idx in 0..lenD) {
            if (idx == lenD || chs[idx] == PUSH_RIGHT) {
                if (lastIdxR > lastIdxL) { // R...R, to turn all to `R`
                    var i = lastIdxR
                    while (i < idx) {
                        chs[i++] = PUSH_RIGHT
                    }
                }

                lastIdxR = idx
            } else if (chs[idx] == PUSH_LEFT) {
                if (lastIdxL > lastIdxR || (lastIdxR == -1 && lastIdxL == -1)) { // L...L, to turn all to `L`
                    var i = lastIdxL
                    while (i < idx) {
                        chs[++i] = PUSH_LEFT
                    }
                } else { // R...L
                    lastIdxL = idx
                    var lo = lastIdxR + 1
                    var hi = lastIdxL - 1
                    while (lo < hi) { // the one in the middle remains `STANDING`
                        chs[lo++] = PUSH_RIGHT
                        chs[hi--] = PUSH_LEFT
                    }
                }
            }
        }

        return String(chs)
    }
}