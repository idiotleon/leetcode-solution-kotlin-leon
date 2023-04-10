/**
 * https://leetcode.com/problems/logical-or-of-two-binary-grids-represented-as-quad-trees/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/logical-or-of-two-binary-grids-represented-as-quad-trees/discuss/249072/Readable-Java-beats-100
 */
package com.idiotleon.leetcode.lvl3.lc0558

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DFSRecursive {
    fun intersect(quadTree1: QuadTreeNode?, quadTree2: QuadTreeNode?): QuadTreeNode? {
        return when {
            quadTree1 == null -> quadTree2
            quadTree2 == null -> quadTree1
            quadTree1.isLeaf -> if (quadTree1.`val`) quadTree1 else quadTree2
            quadTree2.isLeaf -> if (quadTree2.`val`) quadTree2 else quadTree1

            else -> {
                val topLeft = intersect(quadTree1.topLeft, quadTree2.topLeft)
                val topRight = intersect(quadTree1.topRight, quadTree2.topRight)
                val bottomLeft = intersect(quadTree1.bottomLeft, quadTree2.bottomLeft)
                val bottomRight = intersect(quadTree1.bottomRight, quadTree2.bottomRight)

                if (topLeft!!.isLeaf
                    && topRight!!.isLeaf
                    && bottomLeft!!.isLeaf
                    && bottomRight!!.isLeaf
                    && topLeft.`val` == topRight.`val`
                    && bottomLeft.`val` == bottomRight.`val`
                    && topLeft.`val` == bottomLeft.`val`
                ) {
                    QuadTreeNode(topLeft.`val`, true)
                } else {
                    val node = QuadTreeNode(`val` = false, isLeaf = false)
                    node.topLeft = topLeft
                    node.topRight = topRight
                    node.bottomLeft = bottomLeft
                    node.bottomRight = bottomRight

                    node
                }
            }
        }
    }
}