package com.idiotleon.leetcode.lvl5.lc0212

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/word-search-ii/
 * Time Complexity:     O(`nRows` * `nCols` * (4 ^ averageLengthWord))
 * Space Complexity:    O(`nWords` * averageLengthWord)
 */
@Suppress(UNUSED)
class Solution0BacktrackRecursive {
    private companion object {
        const val IMPOSSIBLE: Char = '#'
        val DIRS = intArrayOf(0, -1, 0, 1, 0)
    }

    fun findWords(board: Array<CharArray>, words: Array<String>): List<String> {
        // not used
        // val nWords = words.size
        val nRows = board.size
        val nCols = board[0].size
        val root = buildTrie(words)
        val ans = mutableListOf<String>()
        for (row in 0 until nRows) {
            for (col in 0 until nCols) {
                backtrack(row, col, board, root, ans)
            }
        }
        return ans
    }

    private fun backtrack(row: Int, col: Int, board: Array<CharArray>, node: TrieNode, res: MutableList<String>) {
        val nRows = board.size
        val nCols = board[0].size

        if (row < 0 || row >= nRows || col < 0 || col >= nCols) {
            return
        }

        val hold = board[row][col]
        val idx = hold.code - 'a'.code;
        if (hold == IMPOSSIBLE || node.children[idx] == null) {
            return
        }

        var cur: TrieNode? = node
        cur = cur!!.children[idx]
        if (cur!!.word != null) {
            res.add(cur.word!!)
            cur.word = null
        }

        board[row][col] = IMPOSSIBLE
        for (d in 0 until 4) {
            val r = row + DIRS[d]
            val c = col + DIRS[d + 1]
            backtrack(r, c, board, cur, res)
        }
        board[row][col] = hold
    }

    private fun buildTrie(words: Array<String>): TrieNode {
        val root = TrieNode()
        for (word in words) {
            var cur: TrieNode? = root
            for (ch in word) {
                val idx = ch.code - 'a'.code
                if (cur!!.children[idx] == null) {
                    cur.children[idx] = TrieNode()
                }

                cur = cur.children[idx]
            }
            cur!!.word = word
        }
        return root
    }

    private data class TrieNode(var word: String? = null) {
        val children: Array<TrieNode?> = Array(26) { null }
    }
}