package com.idiotleon.leetcode.lvl2.lc0789

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import kotlin.math.abs

/**
 * @author: Leon
 * https://leetcode.com/problems/escape-the-ghosts/
 *
 * Time Complexity:     O(`nGhosts`)
 * Space Complexity:    O(1)
 *
 * Reference:
 * https://leetcode.com/problems/escape-the-ghosts/discuss/116678/Why-interception-in-the-middle-is-not-a-good-idea-for-ghosts.
 * https://leetcode.com/problems/escape-the-ghosts/discuss/116507/Java-5-liner
 */
@Suppress(UNUSED)
class SolutionApproach0Geometry {
    fun escapeGhosts(ghosts: Array<IntArray>, target: IntArray): Boolean {
        // not used
        // val nGhosts = ghosts.size

        val max = abs(target[0] - 0) + abs(target[1] - 0)

        for (ghost in ghosts) {
            val distance = abs(ghost[0] - target[0]) + abs(ghost[1] - target[1])
            if (distance <= max) return false
        }

        return true
    }
}