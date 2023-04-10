package com.idiotleon.leetcode.lvl1.lc0014

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import kotlin.collections.ArrayDeque

/**
 * @author: Leon
 * https://leetcode.com/problems/longest-common-prefix/
 *
 * Time Complexity:     O(`nStrs` * lenS)
 * Space Complexity:    O(`nStrs` * lenS)
 */
@Suppress(UNUSED)
class SolutionApproach0Trie {
    fun longestCommonPrefix(strs: Array<String>): String {
        val root = buildTrie(strs)

        val builder = StringBuilder()

        val queue = ArrayDeque<TrieNode>().also {
            it.addLast(root)
        }

        outer@ while (queue.isNotEmpty()) {
            val size = queue.size

            if (size > 1) break@outer

            for (sz in 0 until size) {
                val cur = queue.removeFirst()
                cur.ch?.let { builder.append(it) }

                for (child in cur.children) {
                    if (child != null)
                        queue.addLast(child)
                }

                if (cur.word != null) break@outer
            }
        }

        return builder.toString()
    }

    private fun buildTrie(strs: Array<String>): TrieNode {
        val root = TrieNode()

        for (str in strs) {
            var cur = root

            for (ch in str) {
                if (cur.children[ch - 'a'] == null)
                    cur.children[ch - 'a'] = TrieNode(ch)

                cur = cur.children[ch - 'a']!!
            }

            cur.word = str
        }

        return root
    }

    private data class TrieNode(
        var ch: Char? = null,
        var word: String? = null,
        val children: Array<TrieNode?> = Array(26) { null }
    )
}