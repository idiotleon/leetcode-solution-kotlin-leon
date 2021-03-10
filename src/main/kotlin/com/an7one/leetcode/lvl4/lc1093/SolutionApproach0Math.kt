/**
 * https://leetcode.com/problems/statistics-from-a-large-sample/
 *
 * Time Complexity:     O(`RANGE`)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/statistics-from-a-large-sample/discuss/317857/Java-Simple-2-pass-code-w-comments-and-explanation.
 */
package com.an7one.leetcode.lvl4.lc1093

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Math {
    private companion object {
        private const val RANGE = 256
    }

    fun sampleStats(count: IntArray): DoubleArray {
        var total = 0
        var mode = 0

        var median = 0.0
        var min = -1.0
        var max = 0.0
        val avg: Double
        var sum = 0.0

        for (idx in 0 until RANGE) {
            if (count[idx] > 0) {
                total += count[idx]
                if (min < 0) min = idx.toDouble()
                max = idx.toDouble()
                sum += idx * count[idx].toDouble()
                if (count[idx] > count[mode]) mode = idx
            }
        }

        avg = sum / total
        if (total == 1) median = sum

        val median1 = (total + 1) / 2
        val median2 = total / 2 + 1

        var cnt = 0
        for (idx in 0 until RANGE) {
            if (total <= 1) break

            if (cnt < median1 && cnt + count[idx] >= median1) {
                median += idx / 2.0
            }

            if (cnt < median2 && cnt + count[idx] >= median2) {
                median += idx / 2.0
            }

            cnt += count[idx]
        }

        return doubleArrayOf(min, max, avg, median, mode.toDouble())
    }
}