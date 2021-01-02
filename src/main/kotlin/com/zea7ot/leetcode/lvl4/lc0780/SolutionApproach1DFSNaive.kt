/**
 * Stackoverflow
 * https://leetcode.com/problems/reaching-points/
 *
 * Time Complexity:     O(2 ^ N)
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/reaching-points/discuss/375429/Detailed-explanation.-or-full-through-process-or-Java-100-beat
 */
package com.zea7ot.leetcode.lvl4.lc0780

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach1DFSNaive {
    fun reachingPoints(sx: Int, sy: Int, tx: Int, ty: Int): Boolean {
        if (sx == tx && sy == ty) return true

        if (sx > tx || sy > ty) return false

        return reachingPoints(sx + sy, sy, tx, ty) || reachingPoints(sx, sx + sy, tx, ty)
    }
}