/**
 * Time Complexities:
 *  build():            O(`nNums`)
 *  update():           O(lg(`nNums`))
 *  query():            O(lg(`nNums`))
 *
 * Space Complexity:    O(`nNums`)
 *
 * References:
 *  https://youtu.be/e_bK-dgPvfM
 */
package com.an7one.summary.byDataStructure.tree.segmentTree.array.rangeSum

class SegmentTree1(private val nums: IntArray) {
    private val nNums = nums.size
    private val tree = IntArray(2 * nNums + 2 + 1) { 0 }

    init {
        buildTree(0, 0, nums.lastIndex, nums, tree)
    }

    fun update(idx: Int, value: Int) = update(idx, value, 0, 0, nNums - 1, nums, tree)
    fun query(rangeLo: Int, rangeHi: Int) = query(rangeLo, rangeHi, 0, 0, nNums - 1, nums, tree)

    fun query(rangeLo: Int, rangeHi: Int,
              node: Int,
              start: Int, end: Int,
              nums: IntArray, tree: IntArray): Int {

        if (rangeHi < start || rangeLo > end) return 0
        if (start == end) return tree[node]

        val mid = start + (end - start) / 2
        val leftNode = node * 2 + 1
        val rightNode = node * 2 + 2
        val sumLeft = query(rangeLo, rangeHi, leftNode, start, mid, nums, tree)
        val sumRight = query(rangeLo, rangeHi, rightNode, mid + 1, end, nums, tree)

        return sumLeft + sumRight
    }

    private fun update(idx: Int, value: Int,
                       node: Int,
                       start: Int, end: Int,
                       nums: IntArray, tree: IntArray) {

        if (start == end) {
            nums[idx] = value
            tree[node] = value
            return
        }

        val mid = start + (end - start) / 2
        val leftNode = 2 * node + 1
        val rightNode = 2 * node + 2

        if (idx in start..mid) {
            update(idx, value, leftNode, start, mid, nums, tree)
        } else {
            update(idx, value, rightNode, mid + 1, end, nums, tree)
        }

        tree[node] = tree[leftNode] + tree[rightNode]
    }

    private fun buildTree(node: Int,
                          start: Int,
                          end: Int,
                          nums: IntArray,
                          tree: IntArray) {

        if (start == end) {
            tree[node] = nums[start]
            return
        }

        val mid = start + (end - start) / 2
        val leftNode = 2 * node + 1
        val rightNode = 2 * node + 2

        buildTree(leftNode, start, mid, nums, tree)
        buildTree(rightNode, mid + 1, end, nums, tree)
        tree[node] = tree[leftNode] + tree[rightNode]
    }
}