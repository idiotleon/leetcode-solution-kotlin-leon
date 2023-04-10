/**
 * https://leetcode.com/problems/guess-the-majority-in-a-hidden-array/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/guess-the-majority-in-a-hidden-array/discuss/777014/Python-O(1)-space-with-explanation
 */
package com.idiotleon.leetcode.lvl3.lc1538

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Math {
    fun guessMajority(reader: FakeArrayReader): Int {
        val nNums = reader.length()

        var groupA = 1
        var groupB = 0

        var idxA = -1
        var idxB = -1

        val r0123 = reader.query(0, 1, 2, 3)
        val r0124 = reader.query(0, 1, 2, 4)

        for (idx in 4 until nNums) {
            if (reader.query(0, 1, 2, idx) == r0123) {
                ++groupA
                idxA = idx
            } else {
                ++groupB
                idxB = idx
            }
        }

        val rThree = arrayOf(
            intArrayOf(1, 2, 3, 4),
            intArrayOf(0, 2, 3, 4),
            intArrayOf(0, 1, 3, 4)
        )
        for (idx in 0 until 3) {
            if (reader.query(rThree[idx][0], rThree[idx][1], rThree[idx][2], rThree[idx][3]) == r0124) {
                ++groupA
                idxA = idx
            } else {
                ++groupB
                idxB = idx
            }
        }

        return when {
            groupA > groupB -> idxA
            groupA < groupB -> idxB
            else -> -1
        }
    }

}