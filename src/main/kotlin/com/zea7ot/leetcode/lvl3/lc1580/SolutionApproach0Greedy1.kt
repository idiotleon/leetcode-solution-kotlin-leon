/**
 * this solution is NOT yet correct
 * https://leetcode.com/problems/put-boxes-into-the-warehouse-ii/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/put-boxes-into-the-warehouse-ii/discuss/842215/Java-Clean-solution
 */
package com.zea7ot.leetcode.lvl3.lc1580

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Greedy1 {
    fun maxBoxesInWarehouse(boxes: IntArray, warehouse: IntArray): Int {
        val nBoxes = boxes.size
        val nWarehouse = warehouse.size

        val heights = IntArray(nWarehouse) { 0 }
        var min = warehouse[0]
        for (idx in warehouse.indices) {
            min = minOf(min, warehouse[idx])
            heights[idx] = min
        }

        min = warehouse.last()
        for (idx in warehouse.indices.reversed()) {
            min = minOf(min, warehouse[idx])
            heights[idx] = maxOf(heights[idx], min)
        }

        boxes.sort()
        heights.sort()

        var count = 0
        var idxB = 0

        for (idxW in warehouse.indices) {
            if (boxes[idxB] <= heights[idxW]) {
                if (++idxB >= nBoxes) break
                ++count
            }
        }

        return count
    }
}