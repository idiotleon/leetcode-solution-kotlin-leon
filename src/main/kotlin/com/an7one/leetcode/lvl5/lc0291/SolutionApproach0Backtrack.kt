/**
 * https://leetcode.com/problems/word-pattern-ii/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/word-pattern-ii/discuss/73664/Share-my-Java-backtracking-solution
 */
package com.an7one.leetcode.lvl5.lc0291

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Backtrack {
    fun wordPatternMatch(pattern: String, str: String): Boolean {
        val map = HashMap<Char, String>()
        val seen = HashSet<String>()

        return backtrack(0, pattern, 0, str, seen, map)
    }

    private fun backtrack(
        idxP: Int, pattern: String,
        idxS: Int, str: String,
        seen: HashSet<String>,
        map: HashMap<Char, String>
    ): Boolean {
        val lenP = pattern.length
        val lenS = str.length

        if (idxP == lenP && idxS == lenS) return true
        if (idxP == lenP || idxS == lenS) return false

        val chP = pattern[idxP]

        // if(map.containsKey(chP))
        map[chP]?.let { prevMatch ->
            if (!str.startsWith(prevMatch, idxS)) return false

            return backtrack(idxP + 1, pattern, idxS + prevMatch.length, str, seen, map)
        }

        // pruning here
        var end = str.length
        // by pre-allocating space for later chars,
        // by not considering them at this time
        for (m in idxP + 1 until lenP) {
            end -= (map[pattern[m]] ?: "").length
        }

        for (k in idxS until lenS) {
            val sub = str.substring(idxS, k + 1)

            if (seen.contains(sub)) continue

            // to further backtrack
            map[chP] = sub
            seen.add(sub)
            if (backtrack(idxP + 1, pattern, k + 1, str, seen, map)) return true
            // to backtrack to the previous state
            map.remove(chP)
            seen.remove(sub)
        }

        return false
    }
}