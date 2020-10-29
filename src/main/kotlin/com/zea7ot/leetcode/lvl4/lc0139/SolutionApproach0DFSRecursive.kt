/**
 * https://leetcode.com/problems/word-break/
 *
 * Time Complexity:     O(L ^ 2)
 * Space Complexity:    O(L)
 *
 * References:
 *  https://leetcode.com/problems/word-break/discuss/43819/DFS-with-Path-Memorizing-Java-Solution
 */
package com.zea7ot.leetcode.lvl4.lc0139

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DFSRecursive {
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        // sanity check
        if (s.isEmpty()) return false

        val wordSet = HashSet(wordDict)
        val seen = HashSet<Int>()

        return dfs(0, s, seen, wordSet)
    }

    private fun dfs(cur: Int,
                    str: String,
                    seen: HashSet<Int>,
                    wordSet: HashSet<String>): Boolean {
        val lenS = str.length
        if (cur == lenS) return true
        if (seen.contains(cur)) return false

        for (next in cur + 1..lenS) {
            val sub = str.substring(cur, next)
            if (!wordSet.contains(sub)) continue
            if (dfs(next, str, seen, wordSet)) return true
        }

        seen.add(cur)
        return false
    }
}