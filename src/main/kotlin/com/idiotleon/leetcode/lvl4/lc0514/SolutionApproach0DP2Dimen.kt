/**
 * https://leetcode.com/problems/freedom-trail/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/freedom-trail/discuss/194601/DP-solution-with-detailed-text-and-video-explanation.
 */
package com.idiotleon.leetcode.lvl4.lc0514

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import kotlin.math.abs

@Suppress(UNUSED)
class SolutionApproach0DP2Dimen {
    fun findRotateSteps(ring: String, key: String): Int {
        val lenR = ring.length
        val lenK = key.length

        val dp = Array(lenR) { IntArray(lenK) { Int.MAX_VALUE } }

        val chToIdxes = List(26) { mutableListOf<Int>() }
        for (idx in ring.indices) {
            chToIdxes[ring[idx] - 'a'].add(idx)
        }

        var minSteps = Int.MAX_VALUE
        for (idxKey in key.indices) {
            for (idxRing in chToIdxes[key[idxKey] - 'a']) {
                if (idxKey == 0) {
                    dp[idxRing][0] = 1 + minOf(idxRing, lenR - idxRing)
                } else {
                    val chPrev = key[idxKey - 1]
                    for (idxRingPrev in chToIdxes[chPrev - 'a']) {
                        val diff = minOf(abs(idxRing - idxRingPrev), lenR - (abs(idxRing - idxRingPrev)))
                        dp[idxRing][idxKey] = minOf(dp[idxRing][idxKey], dp[idxRingPrev][idxKey - 1] + diff + 1)
                    }
                }

                if (idxKey == lenK - 1) {
                    minSteps = minOf(minSteps, dp[idxRing][lenK - 1])
                }
            }
        }

        return minSteps
    }
}