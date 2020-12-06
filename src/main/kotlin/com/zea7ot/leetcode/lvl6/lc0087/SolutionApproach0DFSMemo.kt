/**
 * https://leetcode.com/problems/scramble-string/
 *
 * Time Complexity:     O(`len1` ^ 3)
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.wang/leetCode-87-Scramble-String.html
 */
package com.zea7ot.leetcode.lvl6.lc0087

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DFSMemo {
    fun isScramble(s1: String, s2: String): Boolean {
        val memo = HashMap<String, Int>()
        return dfs(s1, s2, memo)
    }

    private fun dfs(str1: String, str2: String, memo: HashMap<String, Int>): Boolean {
        val len1 = str1.length
        val len2 = str2.length

        val hash = "$str1#$str2"

        val res = memo[hash] ?: -1

        if (res == 1) return true
        else if (res == 0) return false

        if (len1 != len2) {
            memo[hash] = 0
            return false
        }

        if (str1 == str2) {
            memo[hash] = 1
            return true
        }

        val freqs = IntArray(26) { 0 }
        for (idx in str1.indices) {
            ++freqs[str1[idx] - 'a']
            --freqs[str2[idx] - 'a']
        }

        for (freq in freqs) {
            if (freq != 0) {
                memo[hash] = 0
                return false
            }
        }

        for (idx in 1 until len1) {
            if (dfs(str1.substring(0, idx), str2.substring(0, idx), memo)
                && dfs(str1.substring(idx), str2.substring(idx), memo)
            ) {
                memo[hash] = 1
                return true
            }

            if (dfs(str1.substring(0, idx), str2.substring(len2 - idx), memo)
                && dfs(str1.substring(idx), str2.substring(0, len2 - idx), memo)
            ) {
                memo[hash] = 1
                return true
            }
        }

        memo[hash] = 0
        return false
    }
}