/**
 * https://leetcode.com/problems/put-boxes-into-the-warehouse-i/
 *
 * Time Complexity:     O(`nBoxes` * lg(`nBoxes`)) + O(`nWarehouse`)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/put-boxes-into-the-warehouse-i/discuss/814301/JAVA-Short-O(NlgN%2BM)-Time-O(1)-Space
 */
package com.zea7ot.leetcode.lvl2.lc1564

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Greedy {
    fun maxBoxesInWarehouse(boxes: IntArray, warehouse: IntArray): Int {
        val nBoxes = boxes.size
        val nWarehouse = warehouse.size

        var count = 0

        boxes.sort()

        for (idx in boxes.indices) {
            if (boxes[nBoxes - idx - 1] <= warehouse[count]) {
                if (++count >= nWarehouse) break
            }
        }

        return count
    }
}