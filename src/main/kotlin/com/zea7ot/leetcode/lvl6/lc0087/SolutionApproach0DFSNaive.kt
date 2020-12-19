/**
 * https://leetcode.com/problems/scramble-string/
 *
 * Time Complexity:     O(`lenS` ^ 5)
 * Space Complexity:    O(`lenS` ^ 4)
 *
 * References:
 *  https://zxi.mytechroad.com/blog/searching/leetcode-87-scramble-string/
 *  https://leetcode.com/problems/scramble-string/discuss/29387/Accepted-Java-solution
 *  https://leetcode.com/problems/scramble-string/discuss/29392/Share-my-4ms-c%2B%2B-recursive-solution
 *  https://leetcode.wang/leetCode-87-Scramble-String.html
 */
package com.zea7ot.leetcode.lvl6.lc0087

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DFSNaive {
    fun isScramble(s1: String, s2: String) = dfs(s1, s2)

    private fun dfs(str1: String, str2: String): Boolean {
        val lenS = str1.length

        if (str1 == str2) return true
        if (getFreqs(str1) != getFreqs(str2)) return false

        for (idx in 1 until lenS) {
            if (dfs(str1.substring(0, idx), str2.substring(0, idx))
                && dfs(str1.substring(idx), str2.substring(idx))
                || dfs(str1.substring(0, idx), str2.substring(lenS - idx))
                && dfs(str1.substring(idx), str2.substring(0, lenS - idx))
            )
                return true
        }

        return false
    }

    private fun getFreqs(str: String): List<Int> {
        val freqs = MutableList(26) { 0 }
        for (ch in str) {
            ++freqs[ch - 'a']
        }
        return freqs
    }
}