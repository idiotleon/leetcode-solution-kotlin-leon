/**
 * https://leetcode.com/problems/longest-uncommon-subsequence-ii/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/longest-uncommon-subsequence-ii/discuss/99443/Java(15ms)-Sort-+-check-subsequence/653278
 *  https://leetcode.com/problems/longest-uncommon-subsequence-ii/discuss/99443/Java(15ms)-Sort-%2B-check-subsequence
 */
package com.an7one.leetcode.lvl3.lc0522

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0LinearScan {
    fun findLUSLength(strs: Array<String>): Int {
        val nStrs = strs.size

        strs.sortBy { -it.length }
        val dupSet = getDup(strs)

        for (hi in strs.indices) {
            if (dupSet.contains(strs[hi])) continue

            if (hi == 0) return strs[hi].length

            for (lo in 0 until hi) {
                if (isSubsequence(strs[lo], strs[hi])) break

                if (lo == hi - 1) return strs[hi].length
            }
        }

        return -1
    }

    private fun getDup(strs: Array<String>): HashSet<String> {
        val total = HashSet<String>()
        val dup = HashSet<String>()
        for (str in strs) {
            if (!total.add(str)) {
                dup.add(str)
            }
        }

        return dup
    }

    private fun isSubsequence(str: String, pattern: String): Boolean {
        val lenS = str.length
        val lenP = pattern.length

        var idxS = 0
        var idxP = 0

        while (idxS < lenS && idxP < lenP) {
            if (str[idxS] == pattern[idxP]) {
                ++idxS
                ++idxP
            } else {
                ++idxS
            }
        }

        return idxP == lenP
    }
}