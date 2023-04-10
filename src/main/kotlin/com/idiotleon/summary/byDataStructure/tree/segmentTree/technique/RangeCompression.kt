/**
 * References:
 *  https://leetcode.com/problems/falling-squares/solution/
 */
package com.idiotleon.summary.byDataStructure.tree.segmentTree.technique

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class RangeCompression {
    fun compressRange(intervals: List<List<Int>>): HashMap<Int, Int> {
        val coordSet = HashSet<Int>()
        for ((start, end) in intervals) {
            coordSet.add(start)
            coordSet.add(end)
        }
        val sortedCoords = coordSet.toMutableList().also { it.sort() }

        val ranksMap = HashMap<Int, Int>()
        var ranks = 1
        for (coord in sortedCoords) ranksMap[coord] = ranks++

        return ranksMap
    }
}