/**
 * https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/discuss/91059/Java-O(n)-solution-using-Trie/275175
 *  https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/discuss/91059/Java-O(n)-solution-using-Trie
 */
package com.idiotleon.leetcode.lvl4.lc0421

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Trie {
    fun findMaximumXOR(nums: IntArray): Int {
        val root = buildTrie(nums)

        var maxSum = Int.MIN_VALUE
        for (num in nums) {
            var cur = root
            var curSum = 0

            for (idx in 31 downTo 0) {
                val curBit = (num shr idx) and 1

                if (cur.children[curBit xor 1] != null) {
                    curSum += (1 shl idx)
                    cur = cur.children[curBit xor 1]!!
                } else {
                    cur = cur.children[curBit]!!
                }

                // to prune here
                if (curSum < maxSum && maxSum - curSum >= (1 shl idx) - 1) break
            }

            maxSum = maxOf(curSum, maxSum)
        }

        return maxSum
    }

    private fun buildTrie(nums: IntArray): TrieNode {
        val root = TrieNode()

        for (num in nums) {
            var cur = root

            for (idx in 31 downTo 0) {
                val curBit = (num shr idx) and 1

                if (cur.children[curBit] == null) {
                    cur.children[curBit] = TrieNode()
                }

                cur = cur.children[curBit]!!
            }
        }

        return root
    }

    private data class TrieNode(val children: Array<TrieNode?> = Array(2) { null })
}