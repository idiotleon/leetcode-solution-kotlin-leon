/**
 * https://leetcode.com/problems/word-break/
 *
 * Time Complexity:     O(L ^ 2)
 * Space Complexity:    O(L)
 *
 * References:
 *  https://leetcode.com/problems/word-break/discuss/43819/DFS-with-Path-Memorizing-Java-Solution
 */
package com.zea7ot.lc.lvl4.lc0139

import com.zea7ot.lc.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DFSRecursive {
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        // sanity check
        if (s.isEmpty()) return false

        val wordSet = HashSet(wordDict)
        val seen = HashSet<Int>()

        return dfs(0, s, seen, wordSet)
    }

    private fun dfs(idx: Int,
                    s: String,
                    seen: HashSet<Int>,
                    wordSet: HashSet<String>): Boolean {

        val len = s.length

        if (idx == len) return true

        if (seen.contains(idx)) return false

        for (i in idx + 1..len) {
            val sub = s.substring(idx, i)

            if (!wordSet.contains(sub)) continue

            if (dfs(i, s, seen, wordSet)) return true
        }

        seen.add(idx)
        return false
    }
}