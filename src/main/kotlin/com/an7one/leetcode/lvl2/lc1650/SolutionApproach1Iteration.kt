/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-iii/
 *
 * Time Complexity:     O(H)
 * Space Complexity:    O(H)
 *
 * Reference:
 *  https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-iii/discuss/932914/Java-in-6-lines/766661
 *  https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-iii/discuss/932914/Java-in-6-lines
 */
package com.an7one.leetcode.lvl2.lc1650

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach1Iteration {
    fun lowestCommonAncestor(p: Node?, q: Node?): Node? {
        val track = HashSet<Node>()

        var curP = p
        var curQ = q

        while (curP != null) {
            if (track.contains(curP))
                return curP
            track.add(curP)
            curP = curP.parent

            val tmp = curP
            curP = curQ
            curQ = tmp
        }

        while (curQ != null) {
            if (track.contains(curQ))
                return curQ

            curQ = curQ.parent
        }

        return null
    }
}