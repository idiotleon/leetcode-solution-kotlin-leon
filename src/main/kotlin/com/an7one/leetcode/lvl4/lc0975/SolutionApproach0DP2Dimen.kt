/**
 * https://leetcode.com/problems/odd-even-jump/
 *
 * Time Complexity:     O(`nJumps` * lg(`nJumps`))
 * Space Complexity:    O(`nJumps`)
 *
 * References:
 *  https://leetcode.com/problems/odd-even-jump/discuss/217974/Java-solution-DP-%2B-TreeMap
 */
package com.an7one.leetcode.lvl4.lc0975

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0DP2Dimen {
    fun oddEvenJumps(jumps: IntArray): Int {
        val nJumps = jumps.size
        val dp = Array(nJumps) { idxJump -> BooleanArray(2) { idxJump == nJumps - 1 } }

        val map = TreeMap<Int, Int>()
        map[jumps.last()] = nJumps - 1

        var count = 1

        for (idx in nJumps - 2 downTo 0) {
            // odd jump
            map.ceilingEntry(jumps[idx])?.let {
                val (_, nextGreater) = it
                dp[idx][0] = dp[nextGreater][1]
            }

            // even jump
            map.floorEntry(jumps[idx])?.let {
                val (_, nextSmaller) = it
                dp[idx][1] = dp[nextSmaller][0]
            }

            map[jumps[idx]] = idx

            count += if (dp[idx][0]) 1 else 0
        }

        return count
    }
}