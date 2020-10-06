/**
 * https://leetcode.com/problems/maximum-length-of-pair-chain/
 *
 * Time Complexity:     O(`totalPairs` * lg(`totalPairs`)) + O(`totalPairs`) ~ O(`totalPairs` * lg(`totalPairs`))
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/maximum-length-of-pair-chain/discuss/105602/easy-dp/136750
 *  https://leetcode.com/problems/maximum-length-of-pair-chain/discuss/105623/Java-Very-Simple-without-DP
 *  https://leetcode.com/problems/maximum-length-of-pair-chain/discuss/105623/Java-Very-Simple-without-DP/337879
 *  https://leetcode.com/problems/maximum-length-of-pair-chain/discuss/225801/Proof-of-the-greedy-solution
 */
package com.zea7ot.leetcode.lvl4.lc0646

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Greedy {
    fun findLongestChain(pairs: Array<IntArray>): Int {
        // sanity check
        if (pairs.isEmpty()) return 0

        val totalPairs = pairs.size
        pairs.sortWith(compareBy { it[1] })

        var prevEnd = pairs[0][1]
        var count = 1

        for (i in 1 until totalPairs) {
            if (pairs[i][0] > prevEnd) {
                ++count
                prevEnd = pairs[i][1]
            }
        }

        return count
    }
}