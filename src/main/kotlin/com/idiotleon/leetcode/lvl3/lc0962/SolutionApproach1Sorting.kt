package com.idiotleon.leetcode.lvl3.lc0962

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/maximum-width-ramp/
 *
 * Time Complexity:     O(`nNums` * lg(`nNums`))
 * Space Complexity:    O(`nNums`)
 *
 * Reference:
 * https://leetcode.com/problems/maximum-width-ramp/discuss/208348/JavaC%2B%2BPython-O(N)-Using-Stack
 */
@Suppress(UNUSED)
class SolutionApproach1Sorting {
    fun maxWidthRamp(nums: IntArray): Int {
        val nNums = nums.size

        val nodes = Array(nNums) { idx -> Node(nums[idx], idx) }
        nodes.sortBy { it.value }

        var widest = 0
        var shortest = nNums

        for (node in nodes) {
            widest = maxOf(widest, node.idx - shortest)
            shortest = minOf(shortest, node.idx)
        }

        return widest
    }

    private data class Node(val value: Int, val idx: Int)
}