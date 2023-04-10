package com.idiotleon.leetcode.ood.lvl5.lc0936

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import kotlin.math.log2
import kotlin.random.Random

/**
 * @author: Leon
 * https://leetcode.com/problems/design-skiplist/
 *
 * Time Complexities:
 *  search:     O()
 *  add:        O()
 *
 * Space Complexity:    O()
 *
 * Reference:
 * https://leetcode.com/problems/design-skiplist/discuss/393713/Python-1-node-per-value-and-100/781202
 * https://leetcode.com/problems/design-skiplist/discuss/393713/Python-1-node-per-value-and-100
 */
@Suppress(UNUSED)
class SolutionApproach0SkipList {
    private companion object {
        private const val RANGE_LEVEL = 16
    }

    private val dummyHead = SkipListNode(-1)

    fun search(target: Int): Boolean {
        val skipList = iterate(target)
        val (node, _) = skipList.last()
        node.levels[0]?.let {
            return it.value == target
        }

        return false
    }

    fun add(num: Int) {
        val idxLevel = minOf(
            RANGE_LEVEL, 1 + (log2(1.0 / Random.nextDouble(1.0)).toInt())
        )

        val newNode = SkipListNode(num)
        val skipList = iterate(num)

        for ((node, nodeLevel) in skipList) {
            if (nodeLevel < idxLevel) {
                val future = node.levels[nodeLevel]
                node.levels[nodeLevel] = newNode
                newNode.levels[nodeLevel] = future
            }
        }
    }

    fun erase(num: Int): Boolean {
        var res = false

        val skipList = iterate(num)

        for ((node, curLevel) in skipList) {
            val future = node.levels[curLevel]
            if (future != null && future.value == num) {
                res = true
                node.levels[curLevel] = future.levels[curLevel]
            }
        }

        return res
    }

    private fun iterate(num: Int): List<Pair<SkipListNode, Int>> {
        var cur = dummyHead

        val res = mutableListOf<Pair<SkipListNode, Int>>()
        for (idxLevel in cur.levels.indices.reversed()) {
            while (true) {
                val iter = cur.levels[idxLevel]
                if (iter != null && iter.value < num) {
                    cur = iter
                } else break
            }

            res.add(Pair(cur, idxLevel))
        }

        return res
    }

    private data class SkipListNode(val value: Int) {
        val levels = Array<SkipListNode?>(RANGE_LEVEL) { null }
    }
}