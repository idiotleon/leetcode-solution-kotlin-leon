/**
 * https://leetcode.com/problems/merge-triplets-to-form-target-triplet/
 *
 * Time Complexity:     O(`nTriplets`)
 * Space Complexity:    O(1)
 *
 * Reference:
 *  https://leetcode.com/problems/merge-triplets-to-form-target-triplet/discuss/1268473/Greedy
 */
package com.an7one.leetcode.lvl3.lc1899

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Greedy {
    fun mergeTriplets(triplets: Array<IntArray>, target: IntArray): Boolean {
        // not used
        // val nTriplets = triplets.size

        val res = IntArray(3) { 0 }

        val (t0, t1, t2) = target

        for ((s0, s1, s2) in triplets) {
            if (s0 <= t0 && s1 <= t1 && s2 <= t2) {
                res[0] = maxOf(res[0], s0)
                res[1] = maxOf(res[1], s1)
                res[2] = maxOf(res[2], s2)
            }
        }

        return res contentEquals target
    }
}