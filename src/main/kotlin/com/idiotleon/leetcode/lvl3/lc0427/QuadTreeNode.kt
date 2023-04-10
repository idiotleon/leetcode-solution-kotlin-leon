package com.idiotleon.leetcode.lvl3.lc0427

class QuadTreeNode(var `val`: Boolean, var isLeaf: Boolean) {
    var topLeft: QuadTreeNode? = null
    var topRight: QuadTreeNode? = null
    var bottomLeft: QuadTreeNode? = null
    var bottomRight: QuadTreeNode? = null
}