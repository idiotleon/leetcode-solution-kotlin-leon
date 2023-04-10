package com.idiotleon.leetcode.lvl4.lc0218

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import java.util.*
import kotlin.collections.ArrayList

/**
 * @author: Leon
 * https://leetcode.com/problems/the-skyline-problem/
 *
 * Time Complexity:     O(`nBlgs` ^ 2)
 * Space Complexity:    O(`nBlgs`)
 *
 * Reference:
 * https://leetcode.com/problems/the-skyline-problem/discuss/61192/Once-for-all-explanation-with-clean-Java-code(O(n2)time-O(n)-space)
 */
@Suppress(UNUSED)
class SolutionApproach1MaxHeap1 {
    fun getSkyline(blds: Array<IntArray>): List<List<Int>> {

        // not used
        // val nBlgs = blds.size

        val buildings = ArrayList<Node>()
        for (building in blds) {
            buildings.add(Node(building[0], -building[2]))
            buildings.add(Node(building[1], building[2]))
        }

        buildings.sortWith(compareBy({ it.xCoord }, { it.height }))

        val maxHeap = PriorityQueue<Int>(compareBy { -it })
        maxHeap.offer(0)

        var prev = 0

        val ans = ArrayList<List<Int>>()
        for (building in buildings) {
            val xCoord = building.xCoord
            val height = building.height
            if (height < 0) {
                maxHeap.offer(-height)
            } else {
                maxHeap.remove(height)
            }

            val cur = maxHeap.peek()

            if (prev != cur) {
                ans.add(arrayListOf(xCoord, cur))
                prev = cur
            }
        }

        return ans
    }

    private data class Node(val xCoord: Int, val height: Int)
}