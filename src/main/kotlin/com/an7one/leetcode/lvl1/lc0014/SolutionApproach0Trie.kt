/**
 * @author: Leon
 * https://leetcode.com/problems/longest-common-prefix/
 *
 * Time Complexity:     O(`nStrs` * lenS)
 * Space Complexity:    O(`nStrs` * lenS)
 */
package com.an7one.leetcode.lvl1.lc0014

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0Trie {
    fun longestCommonPrefix(strs: Array<String>): String {
        val root = buildTrie(strs)

        val builder = StringBuilder()

        val queue = LinkedList<TrieNode>().also {
            it.offer(root)
        }

        outer@ while (queue.isNotEmpty()) {
            val size = queue.size

            if (size > 1) break@outer

            for (sz in 0 until size) {
                val cur = queue.poll()
                cur.letter?.let { builder.append(it) }

                for (child in cur.children) {
                    if (child != null) {
                        queue.offer(child)
                    }
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
                if (cur.children[ch - 'a'] == null) {
                    cur.children[ch - 'a'] = TrieNode(ch)
                }

                cur = cur.children[ch - 'a']!!
            }

            cur.word = str
        }

        return root
    }

    private data class TrieNode(
        var letter: Char? = null,
        var word: String? = null,
        val children: Array<TrieNode?> = Array<TrieNode?>(26) { null }
    )
}