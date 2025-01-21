package com.idiotleon.leetcode.lvl3.lc0339

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/nested-list-weight-sum/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 */
@Suppress(UNUSED)
class Solution0Bfs {
    fun depthSum(nestedList: List<NestedInteger>): Int {
        var depth = 1
        var sum = 0
        val queue = ArrayDeque<NestedInteger>().also {
            for (ni in nestedList) {
                it.addLast(ni)
            }
        }

        while (queue.isNotEmpty()) {
            val sizeQ = queue.size
            for (sz in 0 until sizeQ) {
                val cur = queue.removeFirst()
                if (cur.isInteger()) {
                    sum += (cur.getInteger() ?: 0) * depth
                } else {
                    for (ni in cur.getList() ?: emptyList()) {
                        queue.addLast(ni)
                    }
                }
            }
            ++depth
        }

        return sum
    }
}