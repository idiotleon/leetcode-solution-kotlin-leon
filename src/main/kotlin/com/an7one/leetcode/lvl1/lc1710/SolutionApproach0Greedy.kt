/**
 * https://leetcode.com/problems/maximum-units-on-a-truck/
 *
 * Time Complexity:     O(`nTypes` * lg(`nTypes`))
 * Space Complexity:    O(1)
 *
 * Reference:
 *  https://leetcode.com/problems/maximum-units-on-a-truck/discuss/999125/JavaPython-3-Sort-reversely-by-the-units-then-apply-greedy-algorithm.
 */
package com.an7one.leetcode.lvl1.lc1710

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Greedy {
    fun maximumUnits(boxTypes: Array<IntArray>, truckSize: Int): Int {
        // not used
        // val nTypes = boxTypes.size

        boxTypes.sortBy { -it[1] }

        var maxUnits = 0
        var load = 0

        for ((count, unit) in boxTypes) {
            maxUnits += unit * minOf(count, truckSize - load)
            load += count
            if (load > truckSize)
                break
        }

        return maxUnits
    }
}