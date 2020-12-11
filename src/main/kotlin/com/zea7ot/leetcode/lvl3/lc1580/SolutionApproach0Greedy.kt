/**
 * https://leetcode.com/problems/put-boxes-into-the-warehouse-ii/
 *
 * Time Complexity:     O(`nBoxes` * lg(`nBoxes`)) + O(`nWarehouse`)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/put-boxes-into-the-warehouse-ii/discuss/839298/JAVA-Short-O(NlgN%2BM)-Time-O(1)-Space
 */
package com.zea7ot.leetcode.lvl3.lc1580

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Greedy {
    fun maxBoxesInWarehouse(boxes: IntArray, warehouse: IntArray): Int {
        val nBoxes = boxes.size
        val nWarehouse = warehouse.size

        boxes.sort()
        var lo = 0
        var hi = nWarehouse - 1

        var count = 0

        for (idx in nBoxes - 1 downTo 0) {
            if (lo > hi) break

            when {
                boxes[idx] <= warehouse[lo] -> {
                    ++lo
                    ++count
                }

                boxes[idx] <= warehouse[hi] -> {
                    --hi
                    ++count
                }

                else -> {

                }
            }
        }

        return count
    }
}