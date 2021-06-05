/**
 * https://leetcode.com/problems/design-add-and-search-words-data-structure/
 *
 * Time Complexities:
 *  `addWord`:  O(L)
 *  `search`:   O(L)
 *
 * Space Complexity:    O(N(`addWord`) * L)
 *
 * Reference:
 *  https://leetcode.com/problems/design-add-and-search-words-data-structure/discuss/59554/My-simple-and-clean-Java-code
 */
package com.an7one.leetcode.ood.lvl4.lc0211

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Trie {
    private companion object {
        private const val PLACE_HOLDER = '.'
    }

    private val root: TrieNode = TrieNode()

    fun addWord(word: String) {
        var cur: TrieNode? = this.root
        for (ch in word) {
            val idx = ch - 'a'
            if (cur!!.children[idx] == null)
                cur.children[idx] = TrieNode()

            cur = cur.children[idx]
        }

        cur!!.word = word
    }

    fun search(word: String): Boolean = dfs(0, word, root)

    private fun dfs(idx: Int, word: String, node: TrieNode): Boolean {
        val lenS = word.length
        if (idx == lenS)
            return node.word != null

        val ch = word[idx]
        if (ch != PLACE_HOLDER) {
            val child = node.children[ch - 'a'] ?: return false

            return dfs(idx + 1, word, child)
        } else {
            for (child in node.children) {
                if (child == null)
                    continue

                if (dfs(idx + 1, word, child))
                    return true
            }
        }

        return false
    }

    private data class TrieNode(var word: String? = null) {
        val children = Array<TrieNode?>(26) { null }
    }
}