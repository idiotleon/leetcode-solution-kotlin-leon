/**
 * https://leetcode.com/problems/largest-values-from-labels/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/largest-values-from-labels/discuss/313011/Question-Explanation-and-Simple-Solution-or-Java-or-100/292501
 *  https://leetcode.com/problems/largest-values-from-labels/discuss/313011/Question-Explanation-and-Simple-Solution-or-Java-or-100
 */
package com.idiotleon.leetcode.lvl3.lc1090

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Sort {
    fun largestValsFromLabels(values: IntArray, labels: IntArray, numWanted: Int, useLimit: Int): Int {
        val nItems = values.size
        val items = Array(nItems) { idx -> Item(values[idx], labels[idx]) }
        items.sortBy { -it.value }

        val usedFreqs = HashMap<Int, Int>()
        var sum = 0
        var cntUsed = 0

        for ((value, label) in items) {
            if (cntUsed < numWanted && (usedFreqs[label] ?: 0) < useLimit) {
                sum += value
                usedFreqs[label] = 1 + (usedFreqs[label] ?: 0)
                ++cntUsed
            }
        }

        return sum
    }

    private data class Item(val value: Int, val label: Int)
}