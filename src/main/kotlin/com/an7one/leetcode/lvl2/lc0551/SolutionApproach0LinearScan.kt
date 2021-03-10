/**
 * @author: Leon
 * https://leetcode.com/problems/student-attendance-record-i/
 *
 * Time Complexity:     O(`lenS`)
 * Space Complexity:    O(1)
 */
package com.an7one.leetcode.lvl2.lc0551

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0LinearScan {
    private companion object {
        private const val ABSENT = 'A'
        private const val LATE = 'L'
    }

    fun checkRecord(str: String): Boolean {
        // not used
        // val lenS = str.length

        var cntLate = 0
        var cntAbsent = 0

        for (ch in str) {
            when (ch) {
                LATE -> if (++cntLate > 2) return false
                ABSENT -> {
                    cntLate = 0
                    if (++cntAbsent > 1) return false
                }
                else -> cntLate = 0
            }
        }

        return true
    }
}