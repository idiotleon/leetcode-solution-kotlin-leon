package com.idiotleon.leetcode.lvl2.lc2418

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/sort-the-people/
 *
 * Time Complexity:     O(`nNames` * lg(`nNames`))
 * Space Complexity:    O(1) / O(`nNames`)
 */
@Suppress(UNUSED)
class Solution0Sort {
    fun sortPeople(names: Array<String>, heights: IntArray): Array<String> {
        val nNames = names.size

        val sorted = names.mapIndexed { idx, name -> Node(idx, name) }.sortedByDescending { heights[it.idx] }
        return sorted.map { node -> node.name }.toTypedArray()
    }

    private data class Node(val idx: Int, val name: String)
}