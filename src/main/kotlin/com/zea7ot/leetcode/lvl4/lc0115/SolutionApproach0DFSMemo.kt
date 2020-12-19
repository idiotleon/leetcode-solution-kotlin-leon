/**
 * https://leetcode.com/problems/distinct-subsequences/
 *
 * Time Complexity:     O(`lenS` * `lenT`)
 * Space Complexity:    O(`lenS` * `lenT`)
 *
 * References:
 *  https://leetcode.com/problems/distinct-subsequences/discuss/37413/Concise-JAVA-solution-based-on-DP/315532
 *  https://leetcode.com/problems/distinct-subsequences/discuss/37413/Concise-JAVA-solution-based-on-DP
 *  https://leetcode.wang/leetcode-115-Distinct-Subsequences.html
 *  https://leetcode.com/problems/distinct-subsequences/discuss/37327/Easy-to-understand-DP-in-Java/35364
 */
package com.zea7ot.leetcode.lvl4.lc0115

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DFSMemo {
    fun numDistinct(s: String, t: String): Int {
        val lenS = s.length
        val lenT = t.length

        val memo = Array(lenS + 1) { Array<Int?>(lenT + 1) { null } }
        return dfs(0, s, 0, t, memo)
    }

    private fun dfs(
        idxS: Int, s: String,
        idxT: Int, t: String,
        memo: Array<Array<Int?>>
    ): Int {

        val lenS = s.length
        val lenT = t.length

        if (idxT == lenT) return 1
        if (idxS == lenS) return 0

        memo[idxS][idxT]?.let { return it }

        var count = 0
        if (s[idxS] == t[idxT]) {
            count += dfs(idxS + 1, s, idxT + 1, t, memo)
        }

        count += dfs(idxS + 1, s, idxT, t, memo)

        memo[idxS][idxT] = count
        return count
    }
}