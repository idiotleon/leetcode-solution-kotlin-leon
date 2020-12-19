/**
 * https://leetcode.com/problems/k-empty-slots/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/k-empty-slots/discuss/107948/Iterate-over-time-vs.-iterate-over-position
 */
package com.zea7ot.leetcode.lvl4.lc0683

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach1BST {
    fun kEmptySlots(bulbs: IntArray, k: Int): Int {
        val bst = TreeSet<Int>()

        for (idx in bulbs.indices) {
            val cur = bulbs[idx]
            val lo = cur - (k + 1)
            val hi = cur + (k + 1)

            bst.lower(cur)?.let { if (it == lo) return idx + 1 }
            bst.higher(cur)?.let { if (it == hi) return idx + 1 }

            bst.add(cur)
        }

        return -1
    }
}