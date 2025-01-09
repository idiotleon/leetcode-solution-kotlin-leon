package com.idiotleon.leetcode.lvl4.lc2168

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/unique-substrings-with-equal-digit-frequency/
 *
 * Time Complexity:     O(`lenS` ^ 2)
 * Space Complexity:    O(`lenS`)
 *
 * Reference:
 * https://leetcode.com/problems/unique-substrings-with-equal-digit-frequency/solutions/1759403/java-rolling-hash-13-lines-trie/?envType=weekly-question&envId=2025-01-08
 */
@Suppress(UNUSED)
class Solution0LinearScanWithTrie {
    fun equalDigitFrequency(s: String): Int {
        val lenS = s.length

        val trie = Node()
        var count = 0

        for (lo in 0 until lenS) {
            var cur: Node = trie
            val freqs = IntArray(10) { 0 }
            var unique = 0
            var maxCount = 0
            for (hi in lo until lenS) {
                val digit = s[hi] - '0'
                if (freqs[digit] == 0) {
                    ++unique
                }
                ++freqs[digit]
                maxCount = maxOf(maxCount, freqs[digit])
                if (cur.nodes[digit] == null) {
                    cur.nodes[digit] = Node()
                }
                cur = cur.nodes[digit]!!
                if (unique * maxCount == hi - lo + 1 && !cur.seen) {
                    ++count
                    cur.seen = true
                }
            }
        }

        return count
    }

    private data class Node(
        val nodes: MutableList<Node?> = MutableList(10) { null },
        var seen: Boolean = false,
    )
}