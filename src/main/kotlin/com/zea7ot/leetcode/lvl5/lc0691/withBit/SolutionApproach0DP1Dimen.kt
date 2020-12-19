/**
 * https://leetcode.com/problems/stickers-to-spell-word/
 *
 * Time Complexity:     O(`range` * `nStickers` * `lenT`)
 * Space Complexity:    O(`range`)
 *
 * References:
 *  https://leetcode.com/problems/stickers-to-spell-word/discuss/108333/Rewrite-of-contest-winner's-solution/110545
 *  https://leetcode.com/problems/stickers-to-spell-word/discuss/108333/Rewrite-of-contest-winner's-solution
 */
package com.zea7ot.leetcode.lvl5.lc0691.withBit

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP1Dimen {
    private companion object {
        private const val LEN_RANGE = 15 + 1
    }

    fun minStickers(stickers: Array<String>, target: String): Int {
        // not used
        // val nStickers = stickers.size

        val lenT = target.length
        val range = 1 shl lenT

        val dp = IntArray(range) { idx -> if (idx == 0) 0 else LEN_RANGE }

        for (curComb in 0 until range) {
            if (dp[curComb] == LEN_RANGE) continue

            for (sticker in stickers) {
                var nextComb = curComb
                for (ch in sticker) {
                    for (idxT in target.indices) {
                        val idxBit = 1 shl idxT
                        if (target[idxT] == ch && ((nextComb and idxBit) == 0)) {
                            nextComb = nextComb or idxBit
                            break
                        }
                    }
                }

                dp[nextComb] = minOf(dp[nextComb], 1 + dp[curComb])
            }
        }

        return if (dp.last() == LEN_RANGE) -1 else dp.last()
    }
}