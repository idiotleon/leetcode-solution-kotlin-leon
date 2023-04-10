/**
 * https://leetcode.com/problems/map-sum-pairs/
 *
 * Time Complexities:
 *  `insert()`:         O(`lenS`)
 *  `sum()`:            O(`lenS` * nWords)
 *
 * Space Complexity:    O(`lenS` * nWords)
 */
package com.idiotleon.leetcode.ood.lvl2.lc0677

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Trie {
    private val root = TrieNode()

    fun insert(key: String, value: Int) {
        val lenS = key.length
        var cur: TrieNode? = root

        for ((idx, ch) in key.withIndex()) {
            val idxCh = ch - 'a'

            if (cur!!.children[idxCh] == null)
                if (idx == lenS - 1)
                    cur.children[idxCh] = TrieNode(key, value)
                else
                    cur.children[idxCh] = TrieNode()

            cur = cur.children[idxCh]
        }

        cur!!.value = value
    }

    fun sum(prefix: String): Int {
        var cur: TrieNode? = root

        for (ch in prefix) {
            val child = cur!!.children[ch - 'a'] ?: return 0

            cur = child
        }

        return postorder(cur)
    }

    private fun postorder(node: TrieNode?): Int {
        if (node == null)
            return 0

        var sum = 0

        for (child in node.children) {
            sum += postorder(child)
        }

        return sum + node.value
    }

    private data class TrieNode(val str: String? = null, var value: Int = 0) {
        val children: Array<TrieNode?> = Array(26) { null }
    }
}