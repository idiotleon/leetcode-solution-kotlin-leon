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
class Solution0DfsRecursive {
    fun depthSum(nestedList: List<NestedInteger>): Int {
        return dfs(nestedList, 1)
    }

    private fun dfs(nestedList: List<NestedInteger>, depth: Int): Int {
        var sum = 0
        for (nested in nestedList) {
            sum += if (nested.isInteger()) {
                (nested.getInteger() ?: 0) * depth
            } else {
                dfs(nested.getList() ?: emptyList(), 1 + depth)
            }
        }
        return sum
    }
}