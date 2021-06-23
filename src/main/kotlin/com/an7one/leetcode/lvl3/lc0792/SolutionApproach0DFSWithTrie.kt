/**
 * https://leetcode.com/problems/number-of-matching-subsequences/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * Reference:
 *  https://leetcode.com/problems/number-of-matching-subsequences/discuss/157065/Java-Trie-Solution
 */
package com.an7one.leetcode.lvl3.lc0792

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DFSWithTrie {
    private companion object {
        private const val IMPOSSIBLE = '#'
        private const val ASTERISK = '*'
    }

    fun numMatchingSubseq(s: String, words: Array<String>): Int {
        val root = buildTrie(words)
        return dfs(root, s, 0)
    }

    private fun dfs(node: TrieNode?, str: String, idxCh: Int): Int {
        if (node == null)
            return 0

        val idx = str.indexOf(node.ch, idxCh)
        if (node.ch != IMPOSSIBLE && idx == -1)
            return 0

        var cnt = node.cnt
        for (i in 0 until 26) {
            cnt += dfs(node.children[i], str, if (node.ch == ASTERISK) 0 else idx + 1)
        }

        return cnt
    }

    private fun buildTrie(words: Array<String>): TrieNode {
        val root = TrieNode(IMPOSSIBLE)

        for (word in words) {
            var cur: TrieNode? = root

            for (ch in word) {
                if (cur!!.children[ch - 'a'] == null)
                    cur.children[ch - 'a'] = TrieNode(ch)

                cur = cur!!.children[ch - 'a']
            }

            ++cur!!.cnt
        }

        return root
    }

    private data class TrieNode(
        val ch: Char,
        var cnt: Int = 0,
        val children: Array<TrieNode?> = Array(26) { null }
    )
}