/**
 * https://leetcode.com/problems/reaching-points/
 *
 * Time Complexity:     O(lg(max(`tx, `ty`)))
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/reaching-points/discuss/375429/Detailed-explanation.-or-full-through-process-or-Java-100-beat
 */
package com.zea7ot.leetcode.lvl4.lc0780

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Math {
    fun reachingPoints(sx: Int, sy: Int, tx: Int, ty: Int): Boolean {
        var tx = tx
        var ty = ty

        while (sx < tx && sy < ty) {
            if (tx < ty) {
                ty %= tx
            } else {
                tx %= ty
            }
        }

        if (sx == tx && sy <= ty && (ty - sy) % sx == 0) return true

        return sy == ty && sx <= tx && (tx - sx) % sy == 0
    }
}
}