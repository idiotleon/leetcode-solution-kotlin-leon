/**
 * https://leetcode.com/problems/odd-even-jump/
 *
 * Time Complexity:     O(`nJumps` * lg(`nJumps`))
 * Space Complexity:    O(`nJumps`)
 *
 * References:
 *  https://leetcode.com/problems/odd-even-jump/discuss/217981/JavaC%2B%2BPython-DP-using-Map-or-Stack
 *  https://leetcode.com/problems/odd-even-jump/discuss/419765/And-another-Java-TreeMap-solution-with-explanation
 */
package com.idiotleon.leetcode.lvl4.lc0975

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0DP1Dimen {
    fun oddEvenJumps(jumps: IntArray): Int {
        val nJumps = jumps.size

        val higher = BooleanArray(nJumps) { idx -> idx == nJumps - 1 }
        val lower = BooleanArray(nJumps) { idx -> idx == nJumps - 1 }

        val map = TreeMap<Int, Int>()
        map[jumps.last()] = nJumps - 1

        var count = 1

        for (idx in nJumps - 2 downTo 0) {
            map.floorEntry(jumps[idx])?.let {
                val (_, nextSmaller) = it
                lower[idx] = higher[nextSmaller]
            }

            map.ceilingEntry(jumps[idx])?.let {
                val (_, nextGreater) = it
                higher[idx] = lower[nextGreater]
            }

            if (higher[idx]) ++count
            map[jumps[idx]] = idx
        }

        return count
    }
}