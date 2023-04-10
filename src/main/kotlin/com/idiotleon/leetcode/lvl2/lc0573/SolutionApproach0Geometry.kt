package com.idiotleon.leetcode.lvl2.lc0573

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED_PARAMETER
import kotlin.math.abs

/**
 * @author: Leon
 * https://leetcode.com/problems/squirrel-simulation/
 *
 * Time Complexity:     O(`nNuts`)
 * Space Complexity:    O(1)
 *
 * Reference:
 *  https://leetcode.com/problems/squirrel-simulation/discuss/102842/C%2B%2B-Clean-Code-with-Explanation
 */
@Suppress(UNUSED)
class SolutionApproach0Geometry {
    @Suppress(UNUSED_PARAMETER)
    fun minDistance(height: Int, width: Int, tree: IntArray, squirrel: IntArray, nuts: Array<IntArray>): Int {
        // not used
        // val nNuts = nuts.size

        var sum = 0
        var minDistStart = Int.MAX_VALUE

        for (nut in nuts) {
            val nutToTree = getDist(nut, tree)
            val nutToSquirrel = getDist(nut, squirrel)

            sum += nutToTree
            minDistStart = minOf(minDistStart, nutToSquirrel - nutToTree)
        }

        return 2 * sum + minDistStart
    }

    private fun getDist(a: IntArray, b: IntArray) = abs(a[0] - b[0]) + abs(a[1] - b[1])
}