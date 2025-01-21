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
class Solution0DfsIterative {
    fun depthSum(nestedList: List<NestedInteger>): Int {
        var sum = 0
        val stack = ArrayDeque<Pair<List<NestedInteger>, Int>>().also {
            it.addLast(Pair(nestedList, 1))
        }

        while (stack.isNotEmpty()) {
            val (list, depth) = stack.removeLast()
            for (ni in list) {
                if (ni.isInteger()) {
                    sum += (ni.getInteger() ?: 0) * depth
                } else {
                    stack.addLast(Pair(ni.getList() ?: emptyList(), 1 + depth))
                }
            }
        }

        return sum
    }
}