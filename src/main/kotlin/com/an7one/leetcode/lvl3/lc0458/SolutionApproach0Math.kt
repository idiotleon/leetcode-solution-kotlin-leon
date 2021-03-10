/**
 * https://leetcode.com/problems/poor-pigs/
 *
 * Time Complexity:     O(lg(`attempts`))
 * Space Complexity:    O(1)
 *
 * References:
 *  https://youtu.be/Mn3JEDEJ29k
 *  https://leetcode.com/problems/poor-pigs/discuss/94273/Solution-with-detailed-explanation
 *  https://leetcode.com/problems/poor-pigs/discuss/94266/Another-explanation-and-solution
 */
package com.an7one.leetcode.lvl3.lc0458

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import kotlin.math.pow

@Suppress(UNUSED)
class SolutionApproach0Math {
    fun poorPigs(buckets: Int, minutesToDie: Int, minutesToTest: Int): Int {
        val attempts = minutesToTest / minutesToDie + 1

        var pigs = 0
        while (attempts.toDouble().pow(pigs.toDouble()) < buckets) ++pigs

        return pigs
    }
}