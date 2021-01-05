/**
 * https://leetcode.com/problems/rank-teams-by-votes/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/rank-teams-by-votes/discuss/524853/Java-O(26n+(262-*-log26))-Sort-by-high-rank-vote-to-low-rank-vote/462693
 *  https://leetcode.com/problems/rank-teams-by-votes/discuss/524853/Java-O(26n%2B(262-*-log26))-Sort-by-high-rank-vote-to-low-rank-vote
 */
package com.zea7ot.leetcode.lvl2.lc1366

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Sort {
    private companion object {
        private const val RANGE_LENGTH = 26
        private const val RANGE_LETTER = 26
    }

    fun rankTeams(votes: Array<String>): String {
        // not used
        // val nVotes = votes.size

        val nodes = Array(RANGE_LETTER) { idx -> Node(('A' + idx)) }

        for (vote in votes) {
            for (idx in vote.indices) {
                ++nodes[vote[idx] - 'A'].idxFreqs[idx]
            }
        }

        nodes.sortWith(object : Comparator<Node> {
            override fun compare(a: Node, b: Node): Int {
                for (idx in a.idxFreqs.indices) {
                    if (a.idxFreqs[idx] != b.idxFreqs[idx]) {
                        return b.idxFreqs[idx].compareTo(a.idxFreqs[idx])
                    }
                }

                return a.ch.compareTo(b.ch)
            }
        })

        val builder = StringBuilder()
        for (idx in votes[0].indices) {
            builder.append(nodes[idx].ch)
        }

        return builder.toString()
    }

    private data class Node(val ch: Char) {
        // the frequencies of/by indexes (of the `ch`) in `vote`
        val idxFreqs = IntArray(RANGE_LENGTH) { 0 }
    }
}