package com.idiotleon.leetcode.lvl4.lc0314

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import com.idiotleon.leetcode.util.dataStructure.tree.TreeNode
import java.util.*

/**
 * @author: Leon
 * https://leetcode.com/problems/binary-tree-vertical-order-traversal/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 */
@Suppress(UNUSED)
class Solution0PreorderRecursive {
    class Solution {
        fun verticalOrder(root: TreeNode?): List<List<Int>> {
            if (root == null) {
                return emptyList()
            }

            val map = TreeMap<Int, TreeMap<Int, MutableList<Int>>>().also {
                preorder(0, 0, root, it)
            }

            val ans = mutableListOf<List<Int>>()
            for ((x, mapY) in map) {
                val level = mutableListOf<Int>()
                for ((y, list) in mapY) {
                    level.addAll(list)
                }
                ans.add(level)
            }
            return ans
        }

        private fun preorder(x: Int, y: Int, node: TreeNode?, map: TreeMap<Int, TreeMap<Int, MutableList<Int>>>) {
            if (node == null) {
                return
            }

            map.getOrPut(x) { TreeMap() }.getOrPut(y) { mutableListOf() }.add(node.`val`)
            preorder(x - 1, y + 1, node.left, map)
            preorder(x + 1, y + 1, node.right, map)
        }
    }
}