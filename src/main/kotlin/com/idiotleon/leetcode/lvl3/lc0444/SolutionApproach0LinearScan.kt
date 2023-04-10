package com.idiotleon.leetcode.lvl3.lc0444

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/sequence-reconstruction/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * Reference:
 * https://leetcode.com/problems/sequence-reconstruction/discuss/92572/Simple-Solution-:-one-pass-using-only-array-(C++-92ms-Java-16ms)/97033
 * https://leetcode.com/problems/sequence-reconstruction/discuss/92572/Simple-Solution-%3A-one-pass-using-only-array-(C%2B%2B-92ms-Java-16ms)
 */
@Suppress(UNUSED)
class SolutionApproach0LinearScan {
    fun sequenceReconstruction(org: IntArray, seqs: List<List<Int>>): Boolean {
        if (seqs.isEmpty()) return false
        val nOrg = org.size

        val indexes = IntArray(nOrg + 1) { 0 }
        for (idx in org.indices) indexes[org[idx]] = idx

        val flags = BooleanArray(nOrg + 1)
        var toMatch = nOrg - 1

        for (seq in seqs) {
            for (idx in seq.indices) {
                if (seq[idx] <= 0 || seq[idx] > nOrg) return false
                if (idx == 0) continue
                val prev = seq[idx - 1]
                val cur = seq[idx]
                if (indexes[prev] >= indexes[cur]) return false
                if (!flags[prev] && indexes[prev] + 1 == indexes[cur]) {
                    flags[prev] = true
                    --toMatch
                }
            }
        }

        return toMatch == 0
    }
}