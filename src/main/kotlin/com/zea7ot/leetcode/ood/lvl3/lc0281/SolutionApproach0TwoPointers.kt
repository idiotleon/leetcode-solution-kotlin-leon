/**
 * https://leetcode.com/problems/zigzag-iterator/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/zigzag-iterator/discuss/71819/Java-easy-to-understand-solution-using-Queue!/248405
 */
package com.zea7ot.leetcode.ood.lvl3.lc0281

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0TwoPointers(private val v1: IntArray, private val v2: IntArray) {
    private var idx1 = 0
    private var idx2 = 0

    private val nNums1 = v1.size
    private val nNums2 = v2.size

    fun next() = when {
        idx1 < idx2 && idx1 < nNums1 -> v1[idx1++]
        idx2 < idx1 && idx2 < nNums2 -> v2[idx2++]
        idx1 < nNums1 -> v1[idx1++]
        idx2 < nNums2 -> v2[idx2++]
        else -> -1
    }

    fun hasNext(): Boolean = idx1 < nNums1 || idx2 < nNums2
}