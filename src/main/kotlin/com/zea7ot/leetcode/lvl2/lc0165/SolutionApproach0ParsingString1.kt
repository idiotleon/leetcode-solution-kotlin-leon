/**
 * https://leetcode.com/problems/compare-version-numbers/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * gotta pay attention to possible integer overflow
 *
 * References:
 *  https://leetcode.com/problems/compare-version-numbers/discuss/50774/Accepted-small-Java-solution.
 */
package com.zea7ot.leetcode.lvl2.lc0165

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0ParsingString1 {
    private companion object {
        private val REGEX = "\\.".toRegex()
    }

    fun compareVersion(version1: String, version2: String): Int {
        val ver1 = version1.split(REGEX)
        val nVer1 = ver1.size
        val ver2 = version2.split(REGEX)
        val nVer2 = ver2.size

        var idx = 0
        while (idx < maxOf(nVer1, nVer2)) {
            val num1 = if (idx < nVer1) ver1[idx].toInt() else 0
            val num2 = if (idx < nVer2) ver2[idx].toInt() else 0

            if (num1 != num2) {
                return if (num1 > num2) 1 else -1
            }

            ++idx
        }

        return 0
    }
}