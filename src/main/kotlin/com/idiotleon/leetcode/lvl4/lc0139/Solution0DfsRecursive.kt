package com.idiotleon.leetcode.lvl4.lc0139

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/word-break/
 *
 * Time Complexity:     O(`lenS` ^ 2)
 * Space Complexity:    O(`lenS`)
 *
 * Reference:
 * https://leetcode.com/problems/word-break/discuss/43819/DFS-with-Path-Memorizing-Java-Solution
 */
@Suppress(UNUSED)
class Solution0DfsRecursive {
    fun wordBreak(str: String, wordDict: List<String>): Boolean {
        // not used
        // val lenS = str.length

        // sanity check
        if (str.isEmpty()) {
            return false
        }

        val wordSet = HashSet(wordDict)
        val seen = HashSet<Int>()

        return dfs(0, str, seen, wordSet)
    }

    private fun dfs(
        cur: Int, str: String, seen: HashSet<Int>, wordSet: HashSet<String>
    ): Boolean {
        val lenS = str.length
        if (cur == lenS) {
            return true
        }

        if (seen.contains(cur)) {
            return false
        }

        for (next in cur + 1..lenS) {
            val sub = str.substring(cur, next)
            if (!wordSet.contains(sub)) {
                continue
            }
            if (dfs(next, str, seen, wordSet)) {
                return true
            }
        }

        seen.add(cur)
        return false
    }
}