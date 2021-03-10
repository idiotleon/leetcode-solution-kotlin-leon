/**
 * https://leetcode.com/problems/longest-repeating-substring/
 *
 * Time Complexity:     O(`lenS` ^ 2)
 * Space Complexity:    O(`lenS`)
 *
 * References:
 *  https://leetcode.com/problems/longest-repeating-substring/discuss/332052/Java-Straightforward-Trie-solution-O(N2)
 */
package com.an7one.leetcode.lvl4.lc1062

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Trie {
    fun longestRepeatingSubstring(str: String): Int {
        val lenS = str.length

        val root = TrieNode()
        var longest = 0

        for (lo in str.indices) {
            var cur: TrieNode? = root

            for (hi in lo until lenS) {
                if (cur!!.children[str[hi] - 'a'] == null) {
                    val child = TrieNode()
                    cur.children[str[hi] - 'a'] = child
                    cur = child
                } else {
                    longest = maxOf(longest, hi - lo + 1)
                    cur = cur.children[str[hi] - 'a']
                }
            }
        }

        return longest
    }

    private data class TrieNode(val children: Array<TrieNode?> = Array(26) { null })
}