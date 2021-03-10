/**
 * https://leetcode.com/problems/maximum-width-ramp/
 *
 * Time Complexity:     O(`totalNums` * lg(`totalNums`))
 * Space Complexity:    O(`totalNums`)
 *
 * References:
 *  https://leetcode.com/problems/maximum-width-ramp/discuss/208348/JavaC%2B%2BPython-O(N)-Using-Stack
 */
package com.an7one.leetcode.lvl3.lc0962

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach1Sorting {
    fun maxWidthRamp(nums: IntArray): Int {
        val totalNums = nums.size

        val nodes = Array(totalNums) { idx -> Node(nums[idx], idx) }
        nodes.sortBy { it.value }

        var widest = 0
        var shortest = totalNums

        for (node in nodes) {
            widest = maxOf(widest, node.idx - shortest)
            shortest = minOf(shortest, node.idx)
        }

        return widest
    }

    private data class Node(val value: Int, val idx: Int)
}