/**
 * https://leetcode.com/problems/compare-version-numbers/
 *
 * Time Complexity:     O(max(`len1`, `len2`))
 * Space Complexity:    O(1)
 *
 * gotta pay attention to possible integer overflow
 *
 * References:
 *  https://leetcode.com/problems/compare-version-numbers/discuss/50774/Accepted-small-Java-solution./199430
 *  https://leetcode.com/problems/compare-version-numbers/discuss/50774/Accepted-small-Java-solution.
 */
package com.an7one.leetcode.lvl2.lc0165

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0ParsingString {
    private companion object {
        private const val DOT = '.'
        private const val ZERO = '0'
    }

    fun compareVersion(version1: String, version2: String): Int {
        val len1 = version1.length
        val len2 = version2.length

        var idx1 = 0
        var idx2 = 0

        while (idx1 < len1 || idx2 < len2) {
            var num1 = 0
            var num2 = 0

            while (idx1 < len1 && version1[idx1] != DOT) {
                num1 = num1 * 10 + (version1[idx1] - ZERO)
                ++idx1
            }

            while (idx2 < len2 && version2[idx2] != DOT) {
                num2 = num2 * 10 + (version2[idx2] - ZERO)
                ++idx2
            }

            if (num1 != num2) {
                return if (num1 > num2) 1 else -1
            }

            ++idx1
            ++idx2
        }

        return 0
    }
}